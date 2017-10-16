package ru.stqa.work.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.work.addressbook.model.ContactData;
import ru.stqa.work.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirst_name());
    type(By.name("middlename"), contactData.getMiddle_name());
    type(By.name("lastname"), contactData.getLast_name());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome_phone());
    type(By.name("mobile"), contactData.getMobile_phone());
    type(By.name("work"), contactData.getWork_phone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("homepage"), contactData.getHomepage());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[6]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[6]"));
    }
    type(By.name("byear"), contactData.getBirthday_year());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[6]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[6]"));
    }
    type(By.name("ayear"), contactData.getAnniversary_year());

    // проверка того, что элемента быть не должно
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    /*if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[4]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[5]//option[4]"));
    }*/
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getHome_phone2());
    type(By.name("notes"), contactData.getNotes());
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void contactPage() {
    click(By.linkText("home"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public ContactData infoFormEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
    wd.navigate().back();
    return  new ContactData().withId(contact.getId()).withFirst_name(firstname).withLast_name(lastname)
            .withAddress(address).withHome_phone(home).withMobile_phone(mobile).withWork_phone(work)
            .withEmail(email).withHome_phone2(phone2);
  }

  /*public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("img[alt=\"Edit\"")).click();
  }*/

  //Новый метод открыть страницу редактирования
  public void initContactModificationById(int id) {
    //для начала находим чекбокс
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    //находим родительский элемент относительно чекбокса
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    //беремполный список ячеек внутри строки
    List<WebElement> cells = row.findElements(By.tagName("td"));
    //выбираем по номеру нужную нам ячейку
    cells.get(7).findElement(By.tagName("a")).click();

    //Более короткие примеры для данного метода

    //находим чекбокс (//input[@value = '%s'])> относительно чекбокса поднимаемся на 2 уровня вверх (/../../)> в этой строке ищем 8 ячейку (td[8]) и находим ссылку (/a)
    //wd.findElement(By.xpath(String.format("//input[@value = '%s']/../../td[8]/a", id))).click();
    //подхапрос, который находит строку, внутри которой есть чекбокс с заланным идентификатором
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value = '%s']]/td[8]/a", id))).click();
    //поиск ссылки по идентификтору
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

  }

  public void addNewContactPage() {
    click(By.linkText("add new"));
  }

  public void create(ContactData contact, boolean creation) {
    addNewContactPage();
    fillContactForm(contact, creation);
    submitContactCreation();
    contactCache = null;
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactCreation();
    contactCache = null;
    contactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    acceptDeletionContact();
  }

  public void acceptDeletionContact() {
    wd.switchTo().alert().accept();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstName = cells.get(1).getText();
      String lastName = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String email = cells.get(4).getText();
      contactCache.add(new ContactData().withId(id).withFirst_name(firstName).withLast_name(lastName)
              .withAddress(address).withAllPhones(allPhones).withEmail(email));
    }
    return new Contacts(contactCache);
  }

}

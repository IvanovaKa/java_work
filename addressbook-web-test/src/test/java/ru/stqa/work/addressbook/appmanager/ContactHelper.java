package ru.stqa.work.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.work.addressbook.model.ContactData;

import java.util.ArrayList;
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

  public void openContacts() {
    click(By.linkText("home"));
  }

  /*public void selectContact(int index) {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      wd.findElement(By.name("selected[]")).click();
    }
  }*/

  // выбираем последний элемент из списка для удаления
  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }


  // выбираем последний элемент из списка для модификации
  public void initContactModification(int index) {
    wd.findElements(By.xpath("//tr[@class='odd']/td[8]/a/img")).get(index).click();
  }


  public void addNewContactPage() {
    click(By.linkText("add new"));
  }

  public void createContact(ContactData contact, boolean creation) {
    addNewContactPage();
    fillContactForm(contact, creation);
    submitContactCreation();

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

  public int getContactCout() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
  List<ContactData> contacts = new ArrayList<ContactData>();
  List<WebElement> elements = wd.findElements(By.name("selected[]"));
  for (WebElement element : elements) {
    String name = element.getText();
    ContactData contact = new ContactData(name, null, null, null, null,
            null, null, null, null, null, null,
            null, null, null, null, null, null,
            null, null);
    contacts.add(contact);
  }
  return contacts;
  }
}

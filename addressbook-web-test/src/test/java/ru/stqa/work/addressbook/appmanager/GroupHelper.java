package ru.stqa.work.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.work.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {
  //private FirefoxDriver wd;

  public GroupHelper(WebDriver wd) {
    super(wd);  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  /*private void click(By locator) {
    wd.findElement(locator).click();
  }*/

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  /*private void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }*/

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void acceptDeletionContact() {
    accept(By.name("ok"));
  }

  public void createGroup(GroupData group) {
   initGroupCreation();
   fillGroupForm(group);
   submitGroupCreation();
   returnToGroupPage();
  }

  public int getGroupCout() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
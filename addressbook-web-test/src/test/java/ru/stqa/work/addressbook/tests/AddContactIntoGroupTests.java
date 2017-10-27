package ru.stqa.work.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;
import ru.stqa.work.addressbook.model.Contacts;
import ru.stqa.work.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactIntoGroupTests extends TestBase{

  @BeforeMethod
  public void ensureGroupPreconditions(){
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("group name"));
    }
  }

  @BeforeMethod
  public void ensureContactPreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contact().contactPage();
      app.contact().create(new ContactData().withFirst_name("Name").withMiddle_name("Middle Name").withLast_name("Last Name")
              .withNickname("Nickname").withTitle("Title").withCompany("Company").withAddress("Address")
              .withHome_phone("1111111").withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444")
              .withEmail("email@email.com").withEmail2("email1@email.com").withEmail3("email2@email.com")
              .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withAddress2("Address2")
              .withHome_phone2("5555555").withNotes("Notes"), true);
    }
  }

  @Test
  public void testAddContactIntoGroup() {
    Contacts before = app.contact().all();
    app.contact().contactPage();
    ContactData addContact = before.iterator().next();
    app.contact().addIntoGroup(addContact);
    Contacts after = app.db().contacts();
    app.contact().contactPage();
    assertThat(app.contact().count(), equalTo(before.size()));
    verifyContactListInUI();
  }
}

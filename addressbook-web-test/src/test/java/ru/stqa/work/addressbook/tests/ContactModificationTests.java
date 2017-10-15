package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().contactPage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirst_name("Name").withMiddle_name("Middle Name").withLast_name("Last Name").withNickname("Nickname")
              .withTitle("Title").withCompany("Company").withAddress("Address").withHome_phone("1111111")
              .withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444").withEmail("email@email.com")
              .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
              .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes"), true);
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirst_name("Name").withMiddle_name("Middle Name").withLast_name("Last Name").withNickname("Nickname")
            .withTitle("Title").withCompany("Company").withAddress("Address").withHome_phone("1111111")
            .withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444").withEmail("email@email.com")
            .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
            .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
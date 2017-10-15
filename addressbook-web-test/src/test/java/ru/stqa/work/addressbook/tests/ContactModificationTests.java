package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().contactPage();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData().withFirst_name("Name").withMiddle_name("Middle Name").withLast_name("Last Name").withNickname("Nickname")
              .withTitle("Title").withCompany("Company").withAddress("Address").withHome_phone("1111111")
              .withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444").withEmail("email@email.com")
              .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
              .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes"), true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirst_name("Name").withMiddle_name("Middle Name").withLast_name("Last Name").withNickname("Nickname")
            .withTitle("Title").withCompany("Company").withAddress("Address").withHome_phone("1111111")
            .withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444").withEmail("email@email.com")
            .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
            .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
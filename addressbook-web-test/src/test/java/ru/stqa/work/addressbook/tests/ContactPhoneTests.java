package ru.stqa.work.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.stqa.work.addressbook.tests.TestBase.app;

public class ContactPhoneTests extends TestBase{
/*

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().contactPage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirst_name("Name").withMiddle_name("Middle Name").withLast_name("Last Name")
              .withNickname("Nickname").withTitle("Title").withCompany("Company").withAddress("Address")
              .withHome_phone("1111111").withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444")
              .withEmail("email@email.com").withEmail2("email1@email.com").withEmail3("email2@email.com")
              .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
              .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes"), true);
    }
  }
*/

  @Test
  public void testContactPhones() {
    app.contact().contactPage();
    ContactData contact  = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFormEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFormEditForm.getAddress()));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFormEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome_phone(), contact.getMobile_phone(), contact.getWork_phone(),
            contact.getHome_phone2())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}

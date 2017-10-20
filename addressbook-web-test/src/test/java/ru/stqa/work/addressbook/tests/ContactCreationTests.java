package ru.stqa.work.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;
import ru.stqa.work.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  //(enabled = false)

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/image.png");
    list.add(new Object[]{new ContactData().withFirst_name("name1").withMiddle_name("middle_name1")
            .withLast_name("surname1").withNickname("nickname1").withPhoto(photo).withTitle("title1").withCompany("company1")
            .withAddress("address1").withHome_phone("111111").withMobile_phone("222221").withWork_phone("333331")
            .withFax("444441").withEmail("email1@email1.com").withEmail2("email2@email1.com")
            .withEmail3("email3@email1.com").withHomepage("home_page1").withBirthday_year("1983")
            .withAnniversary_year("1983").withGroup("group name").withAddress2("address2_1").withHome_phone2("555551")
            .withNotes("notes1")});
    list.add(new Object[]{new ContactData().withFirst_name("name2").withMiddle_name("middle_name2")
            .withLast_name("surname2").withNickname("nickname2").withPhoto(photo).withTitle("title2").withCompany("company2")
            .withAddress("address2").withHome_phone("111112").withMobile_phone("222222").withWork_phone("333332")
            .withFax("444442").withEmail("email1@email2.com").withEmail2("email2@email2.com")
            .withEmail3("email3@email2.com").withHomepage("home_page2").withBirthday_year("1984")
            .withAnniversary_year("1984").withGroup("group name").withAddress2("address2_2").withHome_phone2("555552")
            .withNotes("notes2")});
    list.add(new Object[]{new ContactData().withFirst_name("name3").withMiddle_name("middle_name3")
            .withLast_name("surname3").withNickname("nickname3").withPhoto(photo).withTitle("title3").withCompany("company3")
            .withAddress("address3").withHome_phone("111113").withMobile_phone("222223").withWork_phone("333333")
            .withFax("444443").withEmail("email1@email3.com").withEmail2("email2@email3.com")
            .withEmail3("email3@email3.com").withHomepage("home_page3").withBirthday_year("1985")
            .withAnniversary_year("1985").withGroup("group name").withAddress2("address2_3").withHome_phone2("555553")
            .withNotes("notes3")});
    return list.iterator();
  }


  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {

    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    /*File photo = new File("src/test/resources/image.png");*/
    /*ContactData contact = new ContactData()
            .withFirst_name(name).withMiddle_name(middle_name).withLast_name(surname).withNickname(nickname)
            .withPhoto(photo).withTitle(title).withCompany(company).withAddress(address).withHome_phone(home_phone)
            .withMobile_phone(mobile).withWork_phone(work_phone).withFax(fax).withEmail(email)
            .withEmail2(email2).withEmail3(email3).withHomepage(home_page)
            .withBirthday_year(birthday).withAnniversary_year(anniversary).withGroup(group)
            .withAddress2(address2).withHome_phone2(home_phone2).withNotes(notes);*/
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    /*Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));*/
  }
/*
  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/image.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
*/

  @Test
  public void testBadContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    ContactData contact = new ContactData()
            .withFirst_name("Name'").withMiddle_name("Middle Name").withLast_name("Last Name'").withNickname("Nickname")
            .withTitle("Title").withCompany("Company").withAddress("Address").withHome_phone("1111111")
            .withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444").withEmail("email@email.com")
            .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
            .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
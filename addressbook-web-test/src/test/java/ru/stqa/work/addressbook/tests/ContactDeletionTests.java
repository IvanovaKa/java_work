package ru.stqa.work.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;
import ru.stqa.work.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().contactPage();
            app.contact().create(new ContactData().withFirst_name("Name").withMiddle_name("Middle Name").withLast_name("Last Name")
                    .withNickname("Nickname").withTitle("Title").withCompany("Company").withAddress("Address")
                    .withHome_phone("1111111").withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444")
                    .withEmail("email@email.com").withEmail2("email1@email.com").withEmail3("email2@email.com")
                    .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
                    .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));
        verifyContactListInUI();
    }

}
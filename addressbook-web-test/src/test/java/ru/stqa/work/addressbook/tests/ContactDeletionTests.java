package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.getContactHelper().openContacts();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Name", "Middle Name",
                    "Last Name", "Nickname", "Title", "Company", "Address",
                    "1111111", "2222222", "3333333", "4444444",
                    "email@email.com", "homepage", "1983", "1983",
                    "group name","Address2", "5555555", "Notes"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size()-1;
        app.getContactHelper().selectContact(index);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeletionContact();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);
    }

}
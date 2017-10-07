package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getContactHelper().openContacts();
        int before = app.getContactHelper().getContactCout();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Name", "Middle Name",
                    "Last Name", "Nickname", "Title", "Company", "Address",
                    "1111111", "2222222", "3333333", "4444444",
                    "email@email.com", "homepage", "1983", "1983",
                    "group name","Address2", "5555555", "Notes"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeletionContact();
        int after = app.getContactHelper().getContactCout();
        Assert.assertEquals(after, before - 1);
    }

}
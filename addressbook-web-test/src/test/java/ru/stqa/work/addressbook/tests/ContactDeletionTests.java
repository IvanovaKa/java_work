package ru.stqa.work.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getContactHelper().openContacts();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getGroupHelper().acceptDeletionContact();
    }

}
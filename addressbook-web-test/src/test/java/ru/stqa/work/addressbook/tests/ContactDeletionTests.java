package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().contactPage();
        if (app.contact().list().size() == 0){
            app.contact().create(new ContactData("Name", "Middle Name",
                    "Last Name", "Nickname", "Title", "Company", "Address",
                    "1111111", "2222222", "3333333", "4444444",
                    "email@email.com", "homepage", "1983", "1983",
                    "group name","Address2", "5555555", "Notes"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }

}
package ru.stqa.work.addressbook.generators;

import ru.stqa.work.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String
              .format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                      contact.getFirst_name(), contact.getMiddle_name(), contact.getLast_name(),
                      contact.getNickname(), contact.getTitle(), contact.getCompany(),
                      contact.getAddress(), contact.getHome_phone(), contact.getMobile_phone(),
                      contact.getWork_phone(), contact.getFax(), contact.getEmail(),
                      contact.getHomepage(), contact.getBirthday_year(), contact.getAnniversary_year(),
                      contact.getGroup(), contact.getAddress(), contact.getNotes()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirst_name(String.format("Name %s", i))
              .withMiddle_name(String.format("Middle %s", i)).withLast_name(String.format("Surname %s", i))
              .withNickname(String.format("Nickname %s", i)).withTitle(String.format("Title %s", i))
              .withCompany(String.format("Company %s", i)).withAddress(String.format("Address %s", i))
              .withHome_phone(String.format("1111 %s", i)).withMobile_phone(String.format("2222 %s", i))
              .withWork_phone(String.format("3333 %s", i)).withFax(String.format("4444 %s", i))
              .withEmail(String.format("email %s", i)).withHomepage(String.format("homepage %s", i))
              .withBirthday_year(String.format("1983 %s", i)).withAnniversary_year(String.format("1983 %s", i))
              .withGroup(String.format("group %s", i)).withAddress(String.format("Address %s", i))
              .withNotes(String.format("Notes %s", i)));
    }
    return contacts;
  }
}

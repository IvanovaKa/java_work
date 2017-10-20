package ru.stqa.work.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.work.addressbook.model.ContactData;
import ru.stqa.work.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter (names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Targer file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")){
      saveAsCsv(contacts, new File (file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File (file));
    } else {
      System.out.println("unrecognized format" + format);
    }

  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml = xStream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
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

  private List<ContactData> generateContacts(int count) {
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

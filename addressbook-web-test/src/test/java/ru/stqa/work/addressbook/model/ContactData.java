package ru.stqa.work.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")

public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id= Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String first_name;

  @Expose
  @Column(name = "middlename")
  private String middle_name;

  @Expose
  @Column(name = "lastname")
  private String last_name;

  @Expose
  @Column(name = "nickname")
  private String nickname;

  @Expose

  @Column(name = "title")
  private String title;

  @Expose
  @Column(name = "company")
  private String company;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String home_phone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile_phone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String work_phone;

  @Expose
  @Transient
  private String allPhones;

  @Expose
  @Column(name = "fax")
  @Type(type = "text")
  private String fax;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;


  @Expose
  @Transient
  private String allEmails;

  @Expose
  @Column(name = "homepage")
  @Type(type = "text")
  private String homepage;

  @Expose
  @Column(name = "byear")
  private String birthday_year;

  @Expose
  @Column(name = "ayear")
  private String anniversary_year;

  @Expose
  @Transient
  private String group;

  @Expose
  @Column(name = "address2")
  @Type(type = "text")
  private String address2;

  @Expose
  @Column(name = "phone2")
  @Type(type = "text")
  private String home_phone2;

  @Expose
  @Column(name = "notes")
  @Type(type = "text")
  private String notes;

  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();

    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  /*
  public ContactData(String first_name, String middle_name, String last_name, String nickname, String title, String company, String address, String home_phone, String mobile_phone, String work_phone, String fax, String email, String homepage, String birthday_year, String anniversary_year, String group, String address2, String home_phone2, String notes) {
    this.id = Integer.MAX_VALUE;
    this.first_name = first_name;
    this.middle_name = middle_name;
    this.last_name = last_name;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home_phone = home_phone;
    this.mobile_phone = mobile_phone;
    this.work_phone = work_phone;
    this.fax = fax;
    this.email = email;
    this.homepage = homepage;
    this.birthday_year = birthday_year;
    this.anniversary_year = anniversary_year;
    this.group = group;
    this.address2 = address2;
    this.home_phone2 = home_phone2;
    this.notes = notes;
  }

  public ContactData(int id, String first_name, String middle_name, String last_name, String nickname, String title, String company, String address, String home_phone, String mobile_phone, String work_phone, String fax, String email, String homepage, String birthday_year, String anniversary_year, String group, String address2, String home_phone2, String notes) {
    this.id = id;
    this.first_name = first_name;
    this.middle_name = middle_name;
    this.last_name = last_name;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home_phone = home_phone;
    this.mobile_phone = mobile_phone;
    this.work_phone = work_phone;
    this.fax = fax;
    this.email = email;
    this.homepage = homepage;
    this.birthday_year = birthday_year;
    this.anniversary_year = anniversary_year;
    this.group = group;
    this.address2 = address2;
    this.home_phone2 = home_phone2;
    this.notes = notes;
  }*/

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirst_name(String first_name) {
    this.first_name = first_name;
    return this;
  }

  public ContactData withMiddle_name(String middle_name) {
    this.middle_name = middle_name;
    return this;
  }

  public ContactData withLast_name(String last_name) {
    this.last_name = last_name;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHome_phone(String home_phone) {
    this.home_phone = home_phone;
    return this;
  }

  public ContactData withMobile_phone(String mobile_phone) {
    this.mobile_phone = mobile_phone;
    return this;
  }

  public ContactData withWork_phone(String work_phone) {
    this.work_phone = work_phone;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBirthday_year(String birthday_year) {
    this.birthday_year = birthday_year;
    return this;
  }

  public ContactData withAnniversary_year(String anniversary_year) {
    this.anniversary_year = anniversary_year;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withHome_phone2(String home_phone2) {
    this.home_phone2 = home_phone2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getMiddle_name() {
    return middle_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public String getMobile_phone() {
    return mobile_phone;
  }

  public String getWork_phone() {
    return work_phone;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBirthday_year() {
    return birthday_year;
  }

  public String getAnniversary_year() {
    return anniversary_year;
  }

  public String getAddress2() {
    return address2;
  }

  public String getHome_phone2() {
    return home_phone2;
  }

  public String getNotes() {
    return notes;
  }

  public String getGroup() {
    return group;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", first_name='" + first_name + '\'' +
            ", last_name='" + last_name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
    return last_name != null ? last_name.equals(that.last_name) : that.last_name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
    result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
    return result;
  }

}
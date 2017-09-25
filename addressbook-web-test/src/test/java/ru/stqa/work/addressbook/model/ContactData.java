package ru.stqa.work.addressbook.model;

public class ContactData {
  private final String first_name;
  private final String middle_name;
  private final String last_name;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String home_phone;
  private final String mobile_phone;
  private final String work_phone;
  private final String fax;
  private final String email;
  private final String homepage;
  private final String birthday_year;
  private final String anniversary_year;
  private final String address2;
  private final String home_phone2;
  private final String notes;

  public ContactData(String first_name, String middle_name, String last_name, String nickname, String title, String company, String address, String home_phone, String mobile_phone, String work_phone, String fax, String email, String homepage, String birthday_year, String anniversary_year, String address2, String home_phone2, String notes) {
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
    this.address2 = address2;
    this.home_phone2 = home_phone2;
    this.notes = notes;
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
}

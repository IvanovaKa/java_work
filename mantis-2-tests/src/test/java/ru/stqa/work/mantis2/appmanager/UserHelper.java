package ru.stqa.work.mantis2.appmanager;

import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.work.mantis2.model.MailMessage;
import ru.stqa.work.mantis2.model.UserData;

import java.util.List;

public class UserHelper extends HelperBase{

  public UserHelper(ApplicationManager app) {
    super(app);
  }

   //логинемся как админ
  public void login() {
      wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
      type(By.name("username"), "administrator");
      click(By.cssSelector("[type='submit']"));
      type(By.name("password"), "root");
      click(By.cssSelector("[type='submit']"));
  }

  public void selectUser(UserData user) {
    click(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i"));
   // click(By.xpath("//a[contains(@href,'/mantisbt-2.8.0/manage_overview.php')]"));

    click(By.xpath("//a[contains(@href,'/mantisbt-2.8.0/manage_user_page.php')]"));
    click(By.xpath("//a[@href='manage_user_edit_page.php?user_id=50']"));
    click(By.xpath("//span//input[@value='Reset Password']"));
    click(By.xpath("//a[contains(@href, 'manage_user_page.php')]"));
  }

  public void resetPassword() {
    click(By.xpath("//span//input[@value='Reset Password']"));
  }

  public void loginWithNewPassword (String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("[type='submit']"));
  }

  public UserData takeUser (List<UserData> users) {
    UserData userChange = new UserData();
    for (UserData user : users) {
      if (user.getUsername().contains("kate")){
        userChange = user;
        break;
      }
    }
    return userChange;
  }

  public void finish(String confirmationLink, String changePassword) {
    wd.get(confirmationLink);
    type(By.name("password"), changePassword);
    type(By.name("password_confirm"), changePassword);
    click(By.cssSelector("[type='submit']"));
  }
}

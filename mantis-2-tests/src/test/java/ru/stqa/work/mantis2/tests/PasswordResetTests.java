package ru.stqa.work.mantis2.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.work.mantis2.model.MailMessage;
import ru.stqa.work.mantis2.model.UserData;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PasswordResetTests extends TestBase {

  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }
  @Test
  public void testPasswordReset() throws IOException, MessagingException {

    String password = "password";
    String changedPassword = "root";
    List<UserData> users = app.db().readUsers();
    UserData userChange = app.userHelper().takeUser(users);
    String username = userChange.getUsername();
    String email = userChange.getEmail();
    app.userHelper().login();
    app.userHelper().selectUser(userChange);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    //List<MailMessage> mailMessages = app.james().waitForMail(username, password, 80000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.userHelper().finish(confirmationLink, changedPassword);
    assertTrue(app.newSession().login(username, changedPassword));
    //app.session().login(username, changedPassword);
  }

  public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }

}

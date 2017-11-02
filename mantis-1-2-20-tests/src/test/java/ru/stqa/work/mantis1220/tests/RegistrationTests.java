package ru.stqa.work.mantis1220.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends  TestBase{

  @Test
  public void testRegistration() {
    app.registration().start("user1", "user1@localhost.locadomain");
  }
}

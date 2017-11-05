package ru.stqa.work.mantis2.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends  TestBase{

  @Test
  public void testRegistration() {
    app.registration().start("user11", "user11@localhost.locadomain");
  }
}


package ru.stqa.work.rest;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import org.testng.SkipException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

  private boolean isIssueOpen(int issueId) {
    String json = RestAssured.get("http://demo.bugify.com/api/issues/%s.json", issueId).asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return !issues.getAsJsonArray().get(0).getAsJsonObject().get("state_name").toString().contains("Fixed");
    }


  public void skipIfNotFixed(int issueId) throws MalformedURLException, RemoteException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
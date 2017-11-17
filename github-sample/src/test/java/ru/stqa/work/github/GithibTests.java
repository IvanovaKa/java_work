package ru.stqa.work.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithibTests {

  @Test
  public void testCimmits() throws IOException {
    Github github = new RtGithub("e913a1cf462342b0cc43e1d4000c271e00aacc63");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("IvanovaKa", "java_work")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}

package ru.stqa.work.sandbox;

public class Equality {

  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = s1;

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

    String s3 = "firefox";
    String s4 = new String(s3);

    System.out.println(s3 == s4);
    System.out.println(s3.equals(s4));

    String s5 = "firefox";
    String s6 = "firefox";

    System.out.println(s5 == s6);
    System.out.println(s5.equals(s6));

    String s7 = "firefox";
    String s8 = "fire" + "fox";

    System.out.println(s7 == s8);
    System.out.println(s7.equals(s8));

    String s9 = "firefox 2.0";
    String s10 = "firefox" + Math.sqrt(4.0);

    System.out.println(s9 == s10);
    System.out.println(s9.equals(s10));
  }
}

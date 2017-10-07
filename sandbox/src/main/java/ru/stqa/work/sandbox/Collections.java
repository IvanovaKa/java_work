package ru.stqa.work.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    for (int i = 0; i < langs.length; i++) {
      System.out.println("Я хочу выучить " + langs[i]);
    }
    System.out.println();

    // специально для коллекций
    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }
    System.out.println();

  // создаем список
    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
     }
    System.out.println();

    // с помощью итерации
    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));
    }
    System.out.println();

    // список объектов произвольного типа
    List language = Arrays.asList("Java", "C#", "Python", "PHP");

    for (Object l : language) {
      System.out.println("Я хочу выучить " + l);
    }

  }
}

package ru.stqa.work.sandbox;

public class Equation {

  private double a;
  private double b;
  private double c;

  private int n;

  public Equation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;
// неполная конструкция if-then-else - как как отсутствует else => если условие не будет выполнено - то и альтернативы никакой нет
    if (a == 0) {
      System.out.println("Это вырожденное уравнение");
    }

// так тоже можно, но с точки зрения производительности - это плохой вариант
    if (d > 0) {
      n = 2;
    }

    if (d == 0) {
      n = 1;
    }

    if (d < 0){
      n = 0;
    }
  }

  public int rootNumber() {
    return n;
  }
}

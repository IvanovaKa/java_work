package ru.stqa.work.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime (){
    Assert.assertTrue(Primes.isPrimeFaster(Integer.MAX_VALUE));
  }

  // @Test (enabled = false) - запрещает запускать тест
  @Test (enabled = false)
  public void testPrimeLong(){
    long n  = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test
  public void testNonPrime (){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
  }
}

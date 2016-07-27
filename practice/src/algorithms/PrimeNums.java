
package algorithms;

public class PrimeNums {
  
  /**
   * Find out all prime numbers until a given number.
   */
  
  public static boolean isPrime(int num) {
    // Time complexity O(sqrt(num))
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
  
  public static boolean[] primesUntil(int n) {
    // Time complexity O(n log log n)
    // check: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    boolean[] output = new boolean[n + 1];
    for (int i = 2; i <= n; i++) output[i] = true;
    
    for (int i = 2; i <= n; i++) {
      if (!output[i]) continue;
      for (int j = i * i; j <= n; j += i) {
        output[j] = false;
      }
    }
    return output;
  }
  
  public static void main(String[] args) {
    boolean[] primes = primesUntil(500);
    
    System.out.println("5 is a prime: " + primes[5]);
    System.out.println("59 is a prime: " + primes[59]);
    System.out.println("499 is a prime: " + primes[499]);
    System.out.println("500 is a prime: " + primes[500]);
  }
  
}

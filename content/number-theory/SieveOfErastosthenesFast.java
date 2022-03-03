/**
 * Author: Francisco Tórtola
 * Date: 2022
 * License: CC0
 * Description: Generar primos hasta cierto límite
 * Time: O(n)
 * Status: Tested on: tested
 */
import java.util.Vector;
class SieveOfErastosthenesFast {
    static final int MAX_SIZE = 1000001;
    // SPF: guarda el factor primo más pequeño de un número
    //prime: vector con todos los números primos
    static Vector<Boolean>isprime = new Vector<>(MAX_SIZE);
    static Vector<Integer>prime = new Vector<>();
    static Vector<Integer>SPF = new Vector<>(MAX_SIZE);
    // method generate all prime number less then N in O(n)
    static void manipulated_seive(int N) {
        for (int i = 0; i <= N; i++){
            isprime.add(true);
            SPF.add(2);
        }
        // 0 and 1 are not prime
        isprime.set(0, false);
        isprime.set(1, false);
        // Fill rest of the entries
        for (int i=2; i<=N ; i++) {
            // If isPrime[i] == True then i is
            // prime number
            if (isprime.get(i)) {
                // put i into prime[] vector
                prime.add(i);
                // A prime number is its own smallest prime factor
                SPF.set(i, i);
            }
            // Remove all multiples of i*prime[j] which are not prime by making isPrime[i*prime[j]] = false
            // and put smallest prime factor of i*Prime[j] as prime[j]
            // [for exp :let i = 5, j = 0, prime[j] = 2 [ i*prime[j] = 10]
            // so smallest prime factor of '10' is '2' that is prime[j] ]
            // this loop run only one time for number which are not prime
            for (int j = 0; j < prime.size() && i * prime.get(j) < N && prime.get(j) <= SPF.get(i); j++) {
                isprime.set(i * prime.get(j), false);
                // put smallest prime factor of i*prime[j]
                SPF.set(i * prime.get(j), prime.get(j));
            }}}}

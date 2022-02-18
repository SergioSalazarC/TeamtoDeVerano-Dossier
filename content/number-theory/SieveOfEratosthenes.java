

/**
 * Author: Francisco Tórtola
 * Date: 2022
 * License: CC0
 * Description: Generar primos hasta cierto límite
 * Time: lim=100'000'000 $\approx$ 0.8 s.
 * Status: Tested on:
 */

import java.util.LinkedList;
public class SieveOfEratosthenes {
    static LinkedList<Integer> sieveOfErastosthenes(int n){
        boolean prime[] = new boolean[n+1];
        LinkedList<Integer>out = new LinkedList<>();
        for(int p=2; p*p<=n; p++)
            if(!prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = true;
            }
        //Metemos los primos a una lista. prime[p] es falso si p es primo.
        for(int i=2; i<=n; i++)
            if(!prime[i])
                out.add(i);
        return out;
    }
}

/**
 * Author: Sergio Salazar
 * Date: 03-03-2022
 * License: CC0
 * Description: Determina de forma lineal si un numero es primo, funcionalidad grantizada para numeros menores a 7* 10**18
 * Usage: ModMulLL.java
 * Time: 7 veces la complejidad de $a^b mod c$
 */

static boolean miillerTest(int d, int n) {
        int a = 2 + (int)(Math.random() % (n - 4));
        int x = power(a, d, n);
        if (x == 1 || x == n - 1)  return true;
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1)return false;
            if (x == n - 1) return true;
        }
        return false;
}
static boolean isPrime(int n, int k) {
        if (n <= 1 || n == 4)  return false;
        if (n <= 3) return true;
        int d = n - 1;
        while (d % 2 == 0) d /= 2;
        for (int i = 0; i < k; i++) if (!miillerTest(d, n)) return false;
        return true;
    }




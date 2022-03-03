/**
 * Author: Sergio Salazar
 * Date: 03-03-2022
 * License: CC0
 * Description: Calcula $a\cdot b\bmod c$ (or $a^b \bmod c$) para $0 \le a, b \le c \le 7.2\cdot 10^{18}$.
 * Time: O(1) para \texttt{modmul}, O(\log b) para \texttt{modpow}
 * Status: stress-tested, proven correct

 */

static int BITS=10;
//Si todos los numeros son menores a 2^k  BITS=64-k;
static long po = 1 << BITS;

static long mod_mul(long a, long b, long mod){
        long x = a * (b & (po-1)) %mod;
        while ((b >>= BITS) > 0) {
            a = (a << BITS) % mod;
            x += (a * (b & (po - 1))) % mod;
        }
        return x % mod;
}
static long mod_pow(long a,long b, long mod){
        long res = 1;
        a = a % mod;
        while (b > 0)
        {
            if ((b & 1) > 0) res = (res * a) % mod;
            b = b >> 1;
            a = (a * a) % mod;
        }
        return res;
}


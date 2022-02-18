/**
 * Author: Sergio Salazar
 * Date: 18/02/2022
 * License: CC0
 * Source: http://en.wikipedia.org/wiki/Lucas'_theorem
 * Description: Tª de Lucas: SeaN $n,m$ enteros no negativos y $p$ un primo.
 * Sea $n=n_kp^k+...+n_1p+n_0$ y $m=m_kp^k+...+m_1p+m_0$.
 * Entonces $\binom{n}{m} \equiv \prod_{i=0}^k\binom{n_i}{m_i} \pmod{p}$.
 * fact y invfact deben ser calculados como el factorial y el factorial invertido, por ejemplo desde ModInverse.h.
 * Status: Untested
 * Time: O(\log_p n)
 */

static long chooseModP(long n, long m, int p) {
	long c = 1;
	while (n || m) {
		long a = n % p
		long b = m % p;
		if (a < b) return 0;
		c = c * fact(a) % p * invfact(b) % p * invfact(a - b) % p;
		n /= p; m /= p;
	}
	return c;
}

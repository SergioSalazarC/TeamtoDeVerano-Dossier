/**
 * Author: Håkan Terelius
 * Date: 2009-09-25
 * License: CC0
 * Source: http://en.wikipedia.org/wiki/Lucas'_theorem
 * Description: Lucas' thm: Let $n,m$ be non-negative integers and $p$ a prime.
 * Write $n=n_kp^k+...+n_1p+n_0$ and $m=m_kp^k+...+m_1p+m_0$.
 * Then $\binom{n}{m} \equiv \prod_{i=0}^k\binom{n_i}{m_i} \pmod{p}$.
 * fact and invfact must hold pre-computed factorials / inverse factorials, e.g. from ModInverse.h.
 * Status: Untested
 * Time: O(\log_p n)
 */

int gcd(int a, int b) {
while (b > 0) {
int temp = b; b = a % b; a = temp; }
return a; }
int lcm(int a, int b){ return a*(b/gcd(a,b));}
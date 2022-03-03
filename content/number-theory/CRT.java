/**
 * Author: Francisco Tórtola
 * Date: 2022
 * License: CC0
 * Description: Teorema chino de los restos. Usa ModInverse
 * Time: O(n*log(n))
 * Status: tested
 */
public class CRT {
    // k es el tamanyo de num[] y rem[].
    // Returns el numero minimo.
    // x tal que:
    // x % num[0] = rem[0],
    // x % num[1] = rem[1],
    // ..................
    // x % num[k-2] = rem[k-1]
    // Asumimos que: Los numeros en num[] son coprimos dos a dos (mcd de cada par es 1)
    static int findMinX(int num[], int rem[], int k) {
        // Compute product of all numbers
        int prod = 1;
        for (int i = 0; i < k; i++)
            prod *= num[i];
        // Initialize result
        int result = 0;
        // Apply above formula
        for (int i = 0; i < k; i++) {
            int pp = prod / num[i];
            result += rem[i] * ModInverse.modInverse(pp, num[i]) * pp;
        }
        return result % prod;
    }}

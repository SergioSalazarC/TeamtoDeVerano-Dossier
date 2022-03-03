/**
 * Author: Francisco Tórtola
 * Date: 2022
 * License: CC0
 * Description: Comprueba todas las aparicones de P en T.
 * Time: O(n+m)
 * Status: tested
 */

public class StringMatching {
    char[] T, P; // T = text, P = pattern
    int n, m; // n = length of T, m = length of P
    int [] b; // b = back table0
    void kmpPreprocess() { // call this before calling kmpSearch()
        int i = 0, j = -1; b[0] = -1; // starting values
        while (i < m) { // pre-process the pattern string P
            while (j >= 0 && P[i] != P[j]) j = b[j]; // if different, reset j using b
            i++; j++; // if same, advance both pointers
            b[i] = j;
        }
    }
    void kmpSearch() { // this is similar as kmpPreprocess(), but on string T
        int i = 0, j = 0; // starting values
        while (i < n) { // search through string T
            while (j >= 0 && T[i] != P[j]) j = b[j]; // if different, reset j using b
            i++; j++; // if same, advance both pointers
            if (j == m) { // a match found when j == m
                System.out.printf("P is found at index %d in T\n", i - j);
                j = b[j]; // prepare j for the next possible match
            }}}}

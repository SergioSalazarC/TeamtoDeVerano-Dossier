/**
 * Author: Isaac
 * Date:
 * Description: Return true if you can form a quadrangle
 * Time: O(1)
 */
bool canFormQuadrangle(double a, double b, double c,double d) {
  return (a + b + c> d) && (a + c + d > b) && (b + c + d > a) && (a+b+d>c); }

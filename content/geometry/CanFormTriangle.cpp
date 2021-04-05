/**
 * Author: Isaac
 * Date:
 * Description: Return true if you can form a triangle
 * Time: O(1)
 */
bool canFormTriangle(double a, double b, double c) {
  return (a + b > c) && (a + c > b) && (b + c > a); }

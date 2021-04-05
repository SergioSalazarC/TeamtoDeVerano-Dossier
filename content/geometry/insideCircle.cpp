/**
 * Author: Isaac
 * Date:
 * Description: Return points inside circle
 * Time: O(1)
 */
int insideCircle(point p, point c, double r) { // all integer version
  double dx = p.x - c.x, dy = p.y - c.y;
  double Euc = dx * dx + dy * dy, rSq = r * r; // all integer
  return Euc < rSq ? 0 : Euc == rSq ? 1 : 2; } //inside/border/outside

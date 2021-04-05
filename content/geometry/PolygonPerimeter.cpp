/**
 * Author: Isaac
 * Date: 2009-03-21
 * Description: Returns the perimeter of a polygon
 * Status:
 * Time: O(N)
 */
template <class P>
double dist(P p1, P p2) {
  return hypot(p1.x - p2.x, p1.y - p2.y); }

template <class P>
double perimeter(const vector<P> &Pa) {
  double result = 0.0;
  for (int i = 0; i < (int)Pa.size()-1; i++)
    result += dist(Pa[i], Pa[i+1]);
  return result; }

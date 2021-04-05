/**
 * Author: Isaac
 * Date: 2009-03-21
 * Description: Returns if the polygon it is convex
 * Status:
 * Time: O(N)
 */
 double cross(vec a, vec b) { return a.x * b.y - a.y * b.x; }
// note: to accept collinear points, we have to change the > 0
// returns true if point r is on the left side of line pq
bool ccw(point p, point q, point r) {
  return cross(toVec(p, q), toVec(p, r)) > 0; }
// returns true if point r is on the same line as the line pq
bool collinear(point p, point q, point r) {
  return fabs(cross(toVec(p, q), toVec(p, r))) < EPS; }
bool isConvex(const vector<point> &P) {
  int sz = (int)P.size();
  if (sz <= 3) return false;
  bool isLeft = ccw(P[0], P[1], P[2]); 
  for (int i = 1; i < sz-1; i++) 
    if (ccw(P[i], P[i+1], P[(i+2) == sz ? 1 : i+2]) != isLeft)
      return false;  
  return true; }                                 
  
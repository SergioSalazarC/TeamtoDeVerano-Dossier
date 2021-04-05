/**
 * Author: Isaac
 * Date: 2009-03-21
 * License: CC0
 * Source:
 * Description: Segment Intersection given the points
 */
double dist(point p1, point p2) {// Euclidean distance
  return hypot(p1.x - p2.x, p1.y - p2.y); } 

struct vec { double x, y; 
  vec(double _x, double _y) : x(_x), y(_y) {} };

vec toVec(point a, point b) { 
  return vec(b.x - a.x, b.y - a.y); }

double dot(vec a, vec b) { return (a.x * b.x + a.y * b.y); }

double norm_sq(vec v) { return v.x * v.x + v.y * v.y; }

vec scale(vec v, double s) {  // nonnegative s = [<1 .. 1 .. >1]
  return vec(v.x * s, v.y * s); }// shorter.same.longer

point translate(point p, vec v) { // translate p according to v
  return point(p.x + v.x , p.y + v.y); }

double distToLine(point p, point a, point b, point &c) {
  // formula: c = a + u * ab
  vec ap = toVec(a, p), ab = toVec(a, b);
  double u = dot(ap, ab) / norm_sq(ab);
  c = translate(a, scale(ab, u)); // translate a to c
  return dist(p, c); }

double distToLineSegment(point p, point a, point b, point &c) {
  vec ap = toVec(a, p), ab = toVec(a, b);
  double u = dot(ap, ab) / norm_sq(ab);
  if (u < 0.0) { c = point(a.x, a.y);// closer to a
    return dist(p, a); }
  if (u > 1.0) { c = point(b.x, b.y); // closer to b
    return dist(p, b); }
  return distToLine(p, a, b, c); } // run distToLine as above
/**
 * Author: Isaac
 * Date: 2009-03-21
 * License: CC0
 * Source: 
 * Description: Convert two points to Line
 */
// the answer is stored in the third parameter (pass by reference)
void pointsToLine(point p1, point p2, line &l) {
  if (fabs(p1.x - p2.x) < EPS) {  // vertical line is fine
    l.a = 1.0;   l.b = 0.0;   l.c = -p1.x;// default values
  } else {
    l.a = -(double)(p1.y - p2.y) / (p1.x - p2.x);
    l.b = 1.0; // IMPORTANT: we fix the value of b to 1.0
    l.c = -(double)(l.a * p1.x) - p1.y;
} }
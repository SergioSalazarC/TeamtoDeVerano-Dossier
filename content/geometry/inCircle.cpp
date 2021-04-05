/**
 * Author: Isaac
 * Date:
 * Description: Return incircle radio, area and perimeter of triangle.
 * Time: O(1)
 */
double perimeter(double ab, double bc, double ca) {
  return ab + bc + ca; }

double area(double ab, double bc, double ca) {
  // Heron's formula
  double s = 0.5 * perimeter(ab, bc, ca);
  return sqrt(s) * sqrt(s - ab) * sqrt(s - bc) * sqrt(s - ca); }

double rInCircle(double ab, double bc, double ca) {
  double per = perimeter(ab, bc, ca);
  if(per==0) return 0;
  return area(ab, bc, ca) / (0.5 * per); }
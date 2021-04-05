/**
 * Author: Isaac
 * Date: 2009-03-21
 * License: CC0
 * Source:
 * Description:\\
\begin{minipage}{75mm}
If a unique intersetion point of the lines going through s1,e1 and s2,e2 exists r is set to this point and 1 is returned. If no intersection point exists 0 is returned and if infinitely many exists -1 is returned. If s1==e1 or s2==e2 -1 is returned. The wrong position will be returned if P is Point<int> and the intersection point does not have integer coordinates. Products of three coordinates are used in intermediate steps so watch out for overflow if using int or long long.
\end{minipage}
\begin{minipage}{15mm}
\includegraphics[width=\textwidth]{../content/geometry/lineIntersection}
\end{minipage}
 * Status: tested
 * Usage: 
 * 	point<double> intersection;
 * 	if (1 == LineIntersection(s1,e1,s2,e2,intersection))
 * 		cout << "intersection point at " << intersection << endl;
 */
struct line { double a, b, c; }; 

bool areIntersect(line l1, line l2, point &p) {
    int den = l1.a*l2.b - l1.b*l2.a;
    if(!den) return false; //same line or parallel
    p.x = l1.c*l2.b - l1.b*l2.c;
    if(p.x)  p.x /= den;
    p.y = l1.a*l2.c - l1.c*l2.a;
    if(p.y)  p.y /= den;
    return true;
}
/**
 * Author: Isaac
 * Date: 2009-04-11
 * License: CC0
 * Source: 
 * Description:\\
\begin{minipage}{75mm}
Returns de Area of the QuarterCircles
\end{minipage}
\begin{minipage}{15mm}
\vspace{-2mm}
\includegraphics[width=\textwidth]{../content/geometry/QuarterCircles}
\end{minipage}
 * Status: 
 */
#define PI acos(-1)
double a;
double x, y, z;
z = a*a - a*a*PI/4;
z -= a*a*PI/4 - a*a*PI/6 - ( a*a*PI/6 - a*a*sqrt(3.0)/4 ); //outside
y = a*a - a*a*PI/4 - 2*z; // "triangles"
x = a*a - 4*y - 4*z; //middle
printf("%.3lf %.3lf %.3lf\n", x, 4*y ,4*z);

/**
 * Author: Isaac
 * Date: 2009-03-21
 * License: CC0
 * Source: 
 * Description: Return center of mass
 * Status: 
 */
template <class P>
P centroid(vector<P> g)		//center of mass
{
    double cx = 0.0, cy = 0.0;
    for(unsigned int i = 0; i < g.size() - 1; i++)
    {
        double x1 = g[i].x, y1 = g[i].y;
        double x2 = g[i+1].x, y2 = g[i+1].y;

        double f = x1 * y2 - x2 * y1;
        cx += (x1 + x2) * f;
        cy += (y1 + y2) * f;
    }
    double res = calc_area(g);		//remove abs
    cx /= 6.0 * res;
    cy /= 6.0 * res;
    return P(cx, cy);
}
/**
 * Author: Isaac
 * Date: 2009-03-21
 * License: CC0
 * Source: 
 * Description: Return polygon area.
 * Status: 
 */
double calc_area(vector<P<double>> Pa) {
    double ans = 0;
    for(int i = 0; i < (int)Pa.size()-1; i++)
        ans += Pa[i].x*Pa[i+1].y - Pa[i].y*Pa[i+1].x;
    return fabs(ans)/2.0;
}
/**
 * Author: Isaac
 * Date:
 * Description: Return a vector with the convexhull / convert to array if TLE
 * Time: O(Nlog(N))
 */
template <class P>
double cross(P o, P a, P b) {
    return (a.x-o.x)*(b.y-o.y) - (a.y-o.y)*(b.x-o.x);
	
template <class P>
vector<P> CH(vector<P> Pa){
    vector<P> res;
    sort(Pa.begin(),Pa.end());
    int n = Pa.size();
    int m=0;
    for (int i=0;i<n;i++){
        while (m>1&&cross(res[m-2], res[m-1], Pa[i]) <= 0)res.pop_back(),m--;
        res.push_back(Pa[i]),m++;
    }
    for (int i = n-1, t = m+1; i >= 0; i--) {
        while (m>=t&&cross(res[m-2], res[m-1], Pa[i]) <= 0)res.pop_back(),m--;
        res.push_back(Pa[i]),m++;
    }
    return res;
}
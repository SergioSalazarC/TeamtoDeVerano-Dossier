/**
 * Author: Isaac
 * Date: 2009-03-21
 * License: CC0
 * Source:
 * Description: Heron Theorem with medians 4/3
 **/
int main()
{
    double d1,d2,d3;
    while(scanf("%lf%lf%lf",&d1,&d2,&d3)==3)
    {
        double res = (d1+d2+d3)/2;
        res=(res-d1)*(res-d2)*(res-d3)*res;
        if(res<EPS) printf("-1.000\n");
        else printf("%.3lf\n",sqrt(res)*4/3);
    }
    return 0;
}

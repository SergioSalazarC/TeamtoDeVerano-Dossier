/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Poligono
 * Time:
 * Status: Tested on:
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Polygon {
   static double EPS=1E-9;
   ArrayList<Point> pol;

   public Polygon(ArrayList<Point> pol) {
      this.pol = pol;
   }

   @Override
   public String toString() {
      String k="";
      for(Point p : pol){
         k+="("+p.x+","+p.y+") _ ";
      }
      return k;
   }
   //Tested: No
   double perimeter(){
      double P = 0;
      for(int i=0;i<pol.size()-1;i++){
         Point aux = pol.get(i);
         P+= aux.dist(pol.get(i+1));
      }
      P+=pol.get(0).dist(pol.get(pol.size()-1));
      return P;
   }

   //Tested: uva11447
   double area(){
      double res=0;
      for(int i=0;i<pol.size();i++){
         Point p = (i!=0 ? pol.get(i-1) : pol.get(pol.size()-1) );
         Point q = pol.get(i);
         res+=(p.x-q.x)*(p.y+q.y);
      }
      res= Math.abs(res/2);
      return res;
   }

   //Tested: by hand
   boolean isConvex(){
      int n = pol.size();
      if(n<3) return false;
      boolean isLeft = pol.get(0).ccw(pol.get(n-2),pol.get(n-1));
      for(int i=0;i<pol.size()-2;i++){
         if(pol.get(i+2).ccw(pol.get(i),pol.get(i+1))!=isLeft) return false;
      }
      if(pol.get(1).ccw(pol.get(n-1),pol.get(0))!=isLeft) return false;
      return true;
   }

   //Tested: No
   Point polygonCenter(){
      Point p = new Point(0,0);
      double A = 0;
      for(int i=0,j=pol.size()-1;i<pol.size();j=i++){
         Point pj = pol.get(j);
         Point pi = pol.get(i);
         p = p.suma(pi.suma(pj)).mul(pj.cross(pj,pi));
         A+= pj.cross(pi);
      }
      return (p.div(A).div(3));
   }

   //Tested: uva10112
   //Devuelve cierto si un punto esta en el interior estricto del poligono, descomentar para los bordes
   boolean inPolygon(Point p){
      int n = pol.size();
      double sum=0;
      //if (p.onSegment(pol.get(0),pol.get(n-1))) return true;
      for(int i=0;i<n-1;i++){
         //if (p.onSegment(pol.get(i),pol.get(i+1))) return true;
         Point pi = pol.get(i);
         Point pi1 = pol.get(i+1);
         if(pi1.ccw(p,pi)) sum += p.angle(pi,pi1);
         else sum -= p.angle(pi,pi1);
      }
      Point pi = pol.get(n-1);
      Point pi1 = pol.get(0);
      if(pi1.ccw(p,pi)) sum += p.angle(pi,pi1);
      else sum -= p.angle(pi,pi1);
      return Math.abs(Math.abs(sum)-2*Math.PI)<EPS;
   }

   //Tested: by hand
   //obtenemos la parte izquierda del poligono intersecado por la recta que pasa por a y b
   //Si queremos la parte derecha basta cambiar a b por b a.
   Polygon cutPolygon(Point a, Point b){
      int n = pol.size();
      ArrayList<Point> P=new ArrayList<>();
      for(int i=0;i<n-1;i++){
         double left1= b.resta(a).cross(pol.get(i).resta(a));
         double left2= 0;
         if(i!=n-1) left2=b.resta(a).cross(pol.get(i+1).resta(a));
         if(left1 > -EPS) P.add(pol.get(i));
         if(left1*left2 < -EPS) P.add(Point.lineIntersec(pol.get(i),pol.get(i+1),a,b));
      }
      double left1= b.resta(a).cross(pol.get(n-1).resta(a));
      double left2= b.resta(a).cross(pol.get(0).resta(a));
      if(left1 > -EPS) P.add(pol.get(n-1));
      if(left1*left2 < -EPS) P.add(Point.lineIntersec(pol.get(n-1),pol.get(0),a,b));
      return new Polygon(P);
   }


   static Polygon convexHull(ArrayList<Point> P) {
      Point pivot;
      int i, j, n = (int)P.size();
      if (n <= 3) {
         if (P.get(0).compareTo(P.get(n-1)) != 0) P.add(P.get(0)); // safeguard from corner case
         return new Polygon(P); // special case, the CH is P itself
      }

      // first, find P0 = point with lowest Y and if tie: rightmost X
      int P0 = 0;
      for (i = 1; i < n; i++)
         if (P.get(i).y  < P.get(P0).y ||
                 (P.get(i).y == P.get(P0).y && P.get(i).x > P.get(P0).x))
            P0 = i;

      Point temp = P.get(0); P.set(0, P.get(P0)); P.set(P0 ,temp); // swap P[P0] with P[0]

      // second, sort points by angle w.r.t. P0
      pivot = P.get(0); // use this global variable as reference
      Collections.sort(P, new Comparator<Point>(){
         public int compare(Point a, Point b) { // angle-sorting function
            if (pivot.collinear( a, b))
               return a.dist(pivot) < b.dist(pivot) ? -1 : 1; // which one is closer?
            double d1x = a.x - pivot.x, d1y = a.y - pivot.y;
            double d2x = b.x - pivot.x, d2y = b.y - pivot.y;
            return (Math.atan2(d1y, d1x) - Math.atan2(d2y, d2x)) < 0 ? -1 : 1;
         }
      });

      // third, the ccw tests
      ArrayList<Point> S = new ArrayList<>();
      S.add(P.get(n-1)); S.add(P.get(0)); S.add(P.get(1)); // initial S
      i = 2; // then, we check the rest
      while (i < n) { // note: n must be >= 3 for this method to work
         j = S.size() - 1;
         if (P.get(i).ccw(S.get(j-1), S.get(j))) S.add(P.get(i++)); // left turn, accept
         else S.remove(S.size() - 1); // or pop the top of S until we have a left turn
      }
      return new Polygon(S); }

}

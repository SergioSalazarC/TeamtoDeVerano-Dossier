/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Encontrar los puntos de articulacion de un grafo. (Puntos que al ser eliminados desconectan G)
 * Time: O(E + V)
 * Status: Tested on:
 */

public class TarjanPuntosArticulacion {
    private static int n; //Vertices
    private static ArrayList<Integer>[] graf;
    private static int[] dfs_low, dfs_num, parents,puntart;
    private static boolean[] visit;

    private static void art (int u, int t){
        visit[u]=true;
        dfs_num[u]=t;
        dfs_low[u]=t++;
        int children=0;
        for(Integer v: graf[u]){
            if(!visit[v]){
                children++;
                parents[v] = u;
                art(v,t);
                dfs_low[u]=Math.min(dfs_low[u], dfs_low[v]);
                if(parents[u] == -1 && children>1){
                    puntart[u]=t;
                }
                if(parents[u] != -1 && dfs_low[v]>=dfs_num[u]){
                    puntart[u]=t;
                }
            }
            else if(v!=parents[u]){
                dfs_low[u]=Math.min(dfs_low[u],dfs_num[v]);
            } } }

    public static void main(String[] args){
        dfs_low= new int[n];
        dfs_num= new int[n];
        parents=new int[n];
        Arrays.fill(parents,-1);
        puntart=new int[n];
        visit= new boolean[n];
        art(0,0);
        int puntosdearticulacion=0;
        for(int i=0;i<n;i++){
            if(puntart[i]!=0) puntosdearticulacion++;
        }
    }
}

/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Encontrar los puntos de articulacion, puentes o componentes biconexas de un grafo
 * Time: O(E + V)
 * Status: Tested on:
 */

public class Main {

    private static ArrayList<Integer>[] graf;
    //Se inicializan a 0 con tamanio = cantidad de vertices, parents a -1;
    private static int[] low, disc, parents,ap;
    //Tamanio = cantidad de vertices
    private static boolean[] visit;
    //Para puentes
    private static LinkedList<IntPair> bridge;


    private static void checkart(int u, int v, int children, int t){
        if(parents[u] == -1 && children>1){
            ap[u]=t;
        }
        if(parents[u] != -1 && low[v]>=disc[u]){
            ap[u]=t;
        }
        if(low[v]>disc[u]){
            bridge.add(new IntPair(Math.min(u,v),Math.max(u,v)));
        }
    }

    private static void articulation_and_bridge(int u, int t){
        visit[u]=true;
        disc[u]=t;
        low[u]=t++;
        int children=0;
        for(Integer v: graf[u]){
            if(!visit[v]){
                children++;
                parents[v] = u;
                articulation_and_bridge(v,t);
                low[u]=Math.min(low[u], low[v]);
                checkart(u,v,children,t);
            }
            else if(v!=parents[u]){
                low[u]=Math.min(low[u],disc[v]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
       graf = new ArrayList[n];

        //Construir grafo

        bridge = new LinkedList<>();
        low= new int[n];
        disc= new int[n];
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=-1;
        }
        ap=new int[n];
        visit= new boolean[n];

        for(int i=0;i<n;i++){
            if(visit[i]==false) articulation_and_bridge(i,0);
        }
        int art_points=0;
        for(int i=0;i<n;i++){
            if(ap[i]!=0) art_points++;
        }
        int puentes=0;
        for(IntPair k : bridge){
            puentes++;
        }
    }
}

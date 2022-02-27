/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Encontrar los puntos de articulacion de un grafo. (Puntos que al ser eliminados desconectan G)
 * Time: O(E + V)
 * Status: Tested on:
 */

import java.io.IOException;

public class Main{

    private static final int UNVISITED = 0;        
    
    //Todos los arrays se inicializan a n=numero de vertices
    //HashSet puede ser ArrayList
    private static HashSet<Intpair>[] graf;
    private static int[] dfs_num, dfs_low, dfs_parent, articulation_vertex;
    //Inicializar dfs parent con -1.
    //Para i=0 i<n : si dfs_num == UNVISITED lanzar metodo 
    private static int dfsNumberCounter, dfsRoot, rootChildren,n,puentes;
    //Solo para los puentes
    private static LinkedList<Intpair> lista;   
    

    private static void articulationPointAndBridge(int u) {
        dfs_low[u]= dfsNumberCounter;
        dfs_num[u]= dfsNumberCounter++; // dfs_low[u] <= dfs_num[u]
        for (Intpair v_w : graf[u]) {
            if (dfs_num[v_w.x] == UNVISITED) { // a tree edge
                dfs_parent[v_w.x]= u;
                if (u == dfsRoot) ++rootChildren;        // special case, root

                articulationPointAndBridge(v_w.x);

                if (dfs_low[v_w.x] >= dfs_num[u]) // for articulation point
                    articulation_vertex[u]= 1; // store this information first
                if (dfs_low[v_w.x] > dfs_num[u]){
                    puentes++;
                    lista.add(new Intpair(Math.min(v_w.x,u),Math.max(v_w.x,u)));
                }
                dfs_low[u]= Math.min(dfs_low[u], dfs_low[v_w.x]); // update dfs_low[u]
            }
            else if (v_w.x != dfs_parent[u]) // a back edge and not direct cycle
                dfs_low[u]= Math.min(dfs_low[u], dfs_num[v_w.x]); // update dfs_low[u]
        }
    }

    public static void main(String[] args) throws IOException {
        //CONSTRUIR GRAFO
        for (int u = 0; u < n; ++u){
            if (dfs_num[u] == UNVISITED) {
                dfsRoot = u; rootChildren = 0;
                articulationPointAndBridge(u);
                articulation_vertex[dfsRoot]= ((rootChildren > 1) ? 1 : 0); // special case
            }
        }       
    }
}


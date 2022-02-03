/**
 * Author: Sergio
 * Date: 2022
 * License: CC0
 * Description: Flujo maximo en una red de tuberias
 * Time: O(V*E^2)
 * Status: Tested on:
 */

public class Main {

	HashMap<Integer,Integer>[] grafo

    public static boolean BFS(HashMap<Integer,Integer>[] grafo, int s, int t , int parent[], int v){
        boolean[] visited = new boolean[v];
        visited[s]=true;
        LinkedList<Integer> cola = new LinkedList<>();
        cola.addFirst(s);
        parent[s]=-1;
        while(!cola.isEmpty()){
            int aux = cola.remove();
            for(Integer k :  grafo[aux].keySet()){
                if(!visited[k]){
                    if(k==t){
                        parent[t]=aux;
                        return true;
                    }
                    cola.add(k);
                    parent[k]=aux;
                    visited[k]=true;
                }
            }
        }
        return false;
    }

    public static int fordFulkerson(HashMap<Integer,Integer>[] grafo, int s, int t,int v){
        HashMap<Integer,Integer>[] rgrafo = new HashMap[v];
        for(int i=0;i<v;i++){
            rgrafo[i]=new HashMap<>();
            for(Integer k : grafo[i].keySet()){
                rgrafo[i].put(k,grafo[i].get(k));
            }
        }

        int parent[] = new int[v];

        int flujo_maximo=0;

        while(BFS(rgrafo,s,t,parent,v)){
            int flujo=Integer.MAX_VALUE;
            int camino = t;
            while(camino!=s){
                int aux=parent[camino];
                flujo=Math.min(flujo,rgrafo[aux].get(camino));
                camino=parent[camino];
            }
            camino = t;
            while(camino!=s){
                int aux=parent[camino];
                rgrafo[aux].put(camino,rgrafo[aux].get(camino)-flujo);
                if (rgrafo[aux].get(camino) == 0) {
                    rgrafo[aux].remove(camino);
                }
                rgrafo[camino].put(aux,rgrafo[camino].get(aux)+flujo);
                camino=parent[camino];
            }
            flujo_maximo+=flujo;
        }
        return flujo_maximo;
    }

}

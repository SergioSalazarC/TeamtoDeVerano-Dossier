/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Shortest Path en un grafo ponderado
 * Time: O(E * log(V))
 * Status: Tested on:
 */

public class Dikjstra {
    public static void Dikjstra(int nodos, int inicio){
        PriorityQueue<IntPair> pq = new PriorityQueue<>();
        pq.offer(new IntPair(inicio,0)); //offer==add
        int[] dist = new int[nodos];
        Arrays.fill(dist,1000000000);
        dist[inicio]=0;

        while(!pq.isEmpty()){
            IntPair top = pq.poll(); //poll==remove
            if(top.d > dist[top.v]) continue;
            for(IntPair aux: graf[top.v]){
                if(dist[top.v]+aux.d >= dist[top.v]) continue;
                dist[aux.v]=dist[top.v]+aux.d;
                pq.offer(new IntPair(aux.v,dist[aux.v]));
            } } } }

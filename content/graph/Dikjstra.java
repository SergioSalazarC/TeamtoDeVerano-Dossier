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
        pq.offer(new IntPair(0,inicio)); //offer==add
        int[] dist = new int[nodos];
        Arrays.fill(dist,1000000000);
        dist[inicio]=0;

        while(!pq.isEmpty()){
            IntPair top = pq.poll(); //poll==remove
            int distop=top.d;
            int vtop=top.v;
            if(distop > dist[vtop]) continue;
            for(IntPair aux: graf[vtop]){
                int disaux=aux.d;
                int vaux=aux.v;
                if(dist[vtop]+disaux >= dist[vaux]) continue;
                dist[vaux]=dist[vtop]+disaux;
                pq.offer(new IntPair(dist[vaux],vaux));
            } } } }

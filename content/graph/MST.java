/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Minimum Spanning Tree
 * Time:
 * Status: Tested on:
 */

public class MST{
PriorityQueue<Par> pq = new PriorityQueue<>();
boolean[] visitado= new boolean[nodos];
visitado[0]=true;
for (Par x: grafo[0]) {
    pq.add(x);
}
int coste=0;
int cant=1;
while (!pq.isEmpty()){
    Par top=pq.remove();
    if(!visitado[top.nodo]){
        visitado[top.nodo]=true;
        cant++;
        coste+=top.dist;
        for (Par x: grafo[top.nodo]) {
            pq.add(x);
}}}}

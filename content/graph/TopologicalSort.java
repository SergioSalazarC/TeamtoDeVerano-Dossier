/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Orden en el que realizar n tareas si 1->2 implica que para hacer 2 hace falta hacer 1
 * Time: O(E + V)
 * Status: Tested on:
 */
public class TopologicalSort {
    public static int n; //vertices
    public static ArrayList<Integer> list;
    public static boolean visitados[];
    public static ArrayList<Integer>[] graf;

    public static void dfs_tps(int u){
        visitados[u]=true;
        for (Integer k : graf[u]) {
            if(!visitados[k]){
                dfs_tps(k);
            }
        }
        list.add(u+1);
    }

    public static void main(String[] args) {
        for(int i=0;i<n;i++){
            if(!visitados[i])
                dfs_tps(i);
        }
        //Recorrido en orden inverso
        for(int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        } } }

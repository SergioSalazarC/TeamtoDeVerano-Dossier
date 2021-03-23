/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: BFS-DFS
 * Time: O(E + V)
 * Status: Tested on:
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(int vertices, int start, ArrayList<Integer>[] graf) {
        boolean[] visitados = new boolean[vertices];
        Queue<Integer> cola = new LinkedList<>();
        cola.add(start);
        while (cola.size() > 0) {
            Integer pop = cola.remove();
            if (graf[pop] == null) continue;
            for (Integer k : graf[pop]) {
                if (!visitados[k]) {
                    cola.add(k);
                    visitados[k] = true;
                }

            }
        }
    }
}

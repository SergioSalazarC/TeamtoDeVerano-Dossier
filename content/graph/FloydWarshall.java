/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Encontrar la minima distincia entre TODOS los pares de un grafo, el grafo debe estar descrito por su lista de adyacencia graf[][]
 * Time: O(V^3)
 * Status: Tested on:
 */
public class FloydWarshall {

    public static int[][] graf;

    public static void FW(int n){
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    graf[i][j] = Math.min(graf[i][j], graf[i][k]+graf[k][j]);
    }
}

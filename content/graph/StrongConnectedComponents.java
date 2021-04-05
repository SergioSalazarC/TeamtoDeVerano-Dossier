/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: u-v en la misma scc si existe un camino de u a v y viceversa
 * Time: O(E + V)
 * Status: Tested on:
 */
public class SCC {
    public static LinkedList<Integer> orden;
    public static ArrayList<Integer>[] graf ;
    public static int[] dfs_num;
    public static int[] dfs_low;
    public static boolean[] visited;
    public static int contador;
    public static int numSCC;

    public static int strongConnectedComponents(int u){
        dfs_low[u]=dfs_num[u]=contador++;
        orden.addLast(u);
        visited[u]=true;
	int size=0;
        for(int i=0;i<graf[u].size();i++){
            int v = graf[u].get(i);
            if(dfs_num[v]==-1){
                size=Math.max(strongConnectedComponents(v),size);
            }
            if(visited[v])
                dfs_low[u]=Math.min(dfs_low[u],dfs_low[v]);
        }
        int auxsize=0;
        if(dfs_low[u]==dfs_num[u]){
            numSCC++;
            System.out.print("SCC "+numSCC+":");
            while(true){
                auxsize++;
                int v = orden.removeLast();
                visited[v]=false;
                System.out.print(v+" ");
                if(u==v) break;
            }
            System.out.println();
        }
	size=Math.max(size,auxsize)
        return size;
    }

    public static void main(String[] args) throws IOException {        
          orden = new LinkedList<>();
          dfs_low=new int[h];
          dfs_num=new int[h];
          Arrays.fill(dfs_num,-1);
          Arrays.fill(dfs_low,-1);
          visited=new boolean[h]
          contador=0;
          numSCC=0;
          for(int i=0;i<V;i++){
              if(dfs_num[i]==-1){
                  strongConnectedComponents(i);
              }
          }  	 
    }
}

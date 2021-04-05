/**
 * Author: Sergio
 * Date: 2021
 * License: CC0
 * Description: Union de Intervalos
 * Time: O(n Log(n))
 * Status: Tested on:
 */
public class MergeIntervals {
    public static void main(String[] args) throws IOException {
        ArrayList<IntPair> al = new ArrayList<>();
        for(int i=0;i<q;i++){ //Extremos de los intervalos
            al.add(new IntPair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        } //Ordenar de menor a mayor por el incio del intervalo
        Collections.sort(al);
        Stack<IntPair> stack = new Stack<>();
        stack.push(al.get(0));
        for(int i=1;i<al.size();i++){
            IntPair top = stack.peek();
            if(top.fini<al.get(i).ini){
                stack.push(al.get(i));
            }
            else if(top.fini<al.get(i).fini){
                top.fini=al.get(i).fini;
                stack.pop();
                stack.push(top);
            }
        }
        int total=0;
        while(!stack.isEmpty()){
            IntPair t= stack.pop();
            total+=(t.fini-t.ini+1);
        }
        System.out.println(total);
    }
}

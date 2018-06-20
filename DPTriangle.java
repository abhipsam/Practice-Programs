import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DPTriangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();

       if(n==0 || triangle==null){
           return 0;
       }
       int[] sol = new int[n];

       for(int i=0;i<n;i++){
           sol[i]=triangle.get(n-1).get(i);
       }
       //start from the bottom
       for(int i=n-2;i>=0;i--){
         for(int j=0;j<triangle.get(i+1).size()-1;j++){
            sol[j]=triangle.get(i).get(j)+Math.min(sol[j],sol[j+1]);
         }
       }
       return sol[0];
    }

    public static void main(String args[]){
        List<Integer> integerList = Arrays.asList(-1);
        List<Integer> integerList1 = Arrays.asList(2,3);
        List<Integer> integerList2 = Arrays.asList(1,-1,-3);
       // List<Integer> integerList3 = Arrays.asList(4,1,8,3);
       // List<Integer> integerList = Arrays.asList(2);

        List<List<Integer>> integerListmain=new LinkedList<>();
        integerListmain.add(integerList);
        integerListmain.add(integerList1);
        integerListmain.add(integerList2);
      //  integerListmain.add(integerList3);

        System.out.println("The minimum sum="+minimumTotal(integerListmain));





    }
}

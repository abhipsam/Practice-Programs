import java.util.Arrays;

public class LeetCodeToggleBulbSwitch {
    public static int bulbSwitch(int n) {
      if(n==0 || n==1){
          return n;
      }

      boolean[] sol = new boolean[n+1];
        Arrays.fill(sol, true);

      for(int i=2;i<=n;i++){
          sol[i]=!sol[i];
          int k=i;
          int j=i;
          while(j+k<=n){
              sol[j+k]=!sol[j+k];
              j=j+k;
          }
      }

      int sum=0;
      for(int i=1;i<=n;i++){
          if(sol[i]){
              sum++;
          }
      }
      return sum;
    }

    public static void main(String args[]){
        System.out.println(bulbSwitch(4));
    }
}

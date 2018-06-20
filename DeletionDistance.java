public class DeletionDistance {
    static int deletionDistance(String str1, String str2) {
      int n = str1.length();
      int m = str2.length();

      int[][] sol = new int[n][m];

      for ( int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(i==0){
               sol[i][j]=j;
              }else if(j==0){
                sol[i][j]=i;
              }else if(str1.charAt(i-1)==str2.charAt(j-1)){
                  sol[i][j]= sol[i-1][j-1];
              }else{
                  sol[i][j]=1+Math.min(sol[i][j-1],sol[i-1][j]);
              }
          }
      }
      return sol[n-1][m-1];
    }

    public static void main(String args[]){
        String string1= "dog";
        String string2= "frog";

        System.out.println(deletionDistance(string1,string2));
    }
}

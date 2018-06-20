import java.util.HashSet;

public class FriendCircleLeetCode {
    public static int findCircleNum(int[][] M) {
       int n = M.length;
       int m = M[0].length;

       if(n==0 && m==0 || M==null){
           return 0;
       }

        HashSet<Integer> hashSet = new HashSet<>();

       int friendcircle=0;
       for(int i=0;i<n;i++){
           for(int j =0;j<m;j++){
              if(M[i][j]==1){
                  if(!hashSet.contains(i) && !hashSet.contains(j)){
                      hashSet.add(i);
                      friendcircle=friendcircle+1;
                  } if(!hashSet.contains(j)){
                      hashSet.add(j);
                  }
              }
           }
       }

       return friendcircle;
    }

    public static void main(String args[]){
        int[][] nums={{1,0,1},{1,1,1},{1,1,1}};
        System.out.println(findCircleNum(nums));
    }
}

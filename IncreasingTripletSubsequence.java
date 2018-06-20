import java.util.Arrays;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int n= nums.length;

        if(n==0 || nums==null){
            return false;
        }

        int[] sol = new int[n];
        Arrays.fill(sol,1);
        boolean isExists=false;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && sol[i]<sol[j]+1){
                    sol[i]=sol[j]+1;
                }
            }
            if(sol[i]>=3){
                isExists=true;
                break;
            }
        }
        return isExists;
    }

    public static void main(String args[]){
        int[] nums= {1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }
}

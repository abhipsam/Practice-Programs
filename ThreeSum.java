import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int n = nums.length;
        if(n==0 || nums==null){
            return resultList;
        }

        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int num=nums[i];
            int l=i+1;
            int r=n-1;

            while(l<r){
                if(nums[l]+nums[r]+num==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(num);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    if(!set.contains(num) || !set.contains(nums[l]) || !set.contains(nums[r])) {
                        resultList.add(list);
                    }
                    while(l<r && nums[l]==nums[l-1])
                        l++;
                    while(l<r && nums[r]==nums[r+1])
                        r--;

                }
                if(nums[l]+nums[r]+num<0){
                    l++;
                }else{
                    r--;
                }
            }
        }

        return resultList;
    }

    public static void main(String args[]){
        int[] arr= {};
        List<List<Integer>> list = new ArrayList<>();
    }
}

import java.util.*;

public class FourSumProblem {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if(n==0|| n<4){
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int start=j+1;
                int end=n-1;

                while(start<end){
                    if(nums[i]+nums[j]+nums[start]+nums[end]>target){
                        end--;
                    }
                    else if(nums[i]+nums[j]+nums[start]+nums[end]<target){
                        start++;
                    }else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        start++;
                        end--;

                        while(end!=nums.length-1 && start<end && nums[end]==nums[end+1]){
                            end--;
                        }
                        while(start!=0 && start<end && nums[start]==nums[start-1]){
                            start++;
                        }
                    }

                }
            }

        }
        return result;
    }
    public static void main(String args[]){
        int[] arr={1,0,-1,0,-2,2};
        int target=0;
        List<List<Integer>> resultList=fourSum(arr,target);

        for(List<Integer> integerList : resultList){
            System.out.println();
            for(Integer k:integerList){
                System.out.print(k+" ");
            }
        }

    }
}

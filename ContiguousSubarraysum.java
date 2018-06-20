import java.util.HashMap;

public class ContiguousSubarraysum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap< >();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String args[]){
        int[] arr ={28,54,7,-70,22,65,-6};
        int k=100;
        System.out.println(subarraySum(arr,k));
    }
}

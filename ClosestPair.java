import java.util.HashMap;

public class ClosestPair {
    static int findClosestPair(int[] numbers, int sum) {
        int n = numbers.length;
        if(numbers==null || n==0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!hashMap.containsKey(numbers[i])) {
                hashMap.put(sum - numbers[i], i);
            } else {
                min = Math.min(min, i - hashMap.get(numbers[i]));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String args[]) {
        int[] numbers = {2, 3, 7};
        int sum = 8;
        System.out.print(findClosestPair(numbers, sum));
    }
}

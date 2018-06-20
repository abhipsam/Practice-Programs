public class CountDigitsLintCode {
    public static int digitCounts(int k, int n) {
        // write your code here
        int[] map = new int[n+1];
        for(int i=0;i<=n;i++){
            map[i]=1;
        }

        int len = Integer.toString(n).length();
        int count=0;


        for(int i=len;i>=1;i--){

        }
        return len;
    }

    public static void main(String args[]){
        int n=12;
        System.out.println(digitCounts(1,12));
    }
}

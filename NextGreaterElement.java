public class NextGreaterElement {
    public static int nextGreaterElement(int n) {
      char[] num = (n+"").toCharArray();

      //find the first element less than its next element
        int i=0;
        for(i=num.length-1;n>=0 ;n--){
            if(num[i-1] < num[i]){
                break;
            }
        }

        if(i==0){
            return -1;
        }
        //Find first number which is the least greater than the smallest number
        int smallest=i;int x=i-1;
        for (int j=i+1;i<num.length;i++){
            if(num[j]<= smallest && num[j]>x){
                smallest=num[j];
            }
        }

        char temp = num[smallest];
        num[smallest]=num[i-1];
        num[i-1]=temp;

        long val= Long.parseLong(new String(num));
        return (val>Integer.MAX_VALUE)?-1:(int) val;

    }
    public static void main(String args[]){
        int num =12;
        System.out.println(nextGreaterElement(num));

    }
}

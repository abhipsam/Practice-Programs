public class GoogleQuestion1b2c {
    public static int findNum(int n , int bCount, int cCount){
        if(bCount < 0 || cCount<0){
            return 0;
        }
        if (n==0){
            return 1;
        }
        if(bCount==0 && cCount ==0){
            return 1;
        }

        int  result=findNum(n-1,bCount,cCount);
        result = result+findNum(n-1,bCount-1,cCount);
        result= result +findNum(n-1,bCount,cCount);

        return result;
    }

    public static void main(String args[]){
        int n =3;
        int x =findNum(3,1,2);
        System.out.println("the number of characters="+x);

    }
}

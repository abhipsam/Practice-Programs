public class BadVersion {
    static boolean isBadVersion(int version){
          if(version >=1 && version <=5){
              return true;
          }
        return false;
    }
    public static int firstBadVersion(int n) {
        int low = 1;
        int high=n;

        return findBadVersionHelper(1,n);
    }

    public static int findBadVersionHelper(int low, int high){
        int mid = (low+high)/2;

        if(isBadVersion(mid)==false && isBadVersion(mid-1)==true){
            return mid;
        }else if(isBadVersion(mid)){
            return findBadVersionHelper(mid+1,high);
        }else{
            return findBadVersionHelper(low,mid-1);
        }
    }

    public static void main(String args[]){
        int n = 10;
        System.out.println(firstBadVersion(n));
    }

}

public class NumberOfSegments {
    public static int countSegments(String s) {
      int n = s.length();
      if(n==0 || s==null){
          return 0;
      }

      String[] strings= s.split(" ");
      int count=0;
      for(String x : strings){
          if(!x.equals(" ")){
              count++;
          }
      }

      return count;
    }
}

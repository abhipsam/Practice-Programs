import java.util.*;

public class MergeIntervals {

     //Definition for an interval.
     public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
     }

    public static List<Interval> merge(List<Interval> intervals) {
        Stack<Interval> stack =new Stack<>();
       List<Interval> resultList=new ArrayList<>();

     if(intervals.size()==0){
         return resultList;
     }

     if(intervals.size()==1){
         resultList.add(new Interval(intervals.get(0).start,intervals.get(0).end));
         return resultList;
     }

     Collections.sort(intervals, new Comparator<Interval>() {
         @Override
         public int compare(Interval o1, Interval o2) {
             if(o2.start!=o1.start){
                 return o1.start-o2.start;
             }else{
                 return o1.end-o2.end;
             }
         }
     });
      Interval pre = intervals.get(0);
     for(Interval interval:intervals) {
         Interval curr = interval;
         if (pre.start > curr.end) {
             resultList.add(pre);
             pre = curr;
         } else {
             Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
             pre = merged;
         }
     }
      resultList.add(pre);
        return resultList;
        /* int min=interval.start;
         int max=interval.end;
         if(resultList.size()>0){
             Interval top=resultList.get(resultList.size()-1);

             if((min>top.end && max > top.end) ||(min<top.start && max<top.start) ){
                 min=interval.start;
                 max=interval.end;
             }

             else if(min <= top.start || min <= top.end || max <= top.end || max<=top.start){
                 min=Math.min(min,top.start);
                 max=Math.max(max,top.end);
                 resultList.remove(top);
             }
         }
         resultList.add(new Interval(min,max));*/


    }

    public static void main(String args[]){
         List<Interval> intervalList=new ArrayList<>();
         Interval interval=new Interval(2,3);
         Interval interval1=new Interval(4,5);
         Interval interval2 = new Interval(6,7);
         Interval interval3 =new Interval(8,9);
        Interval interval4 =new Interval(1,10);
       // Interval interval4 =new Interval(1,10);

         intervalList.add(interval);
         intervalList.add(interval1);
         intervalList.add(interval2);
         intervalList.add(interval3);
         intervalList.add(interval4);

        List<Interval> resultList=merge(intervalList);

        for(Interval intervals : resultList){
            System.out.print("("+intervals.start+","+intervals.end+")");
            System.out.println();
        }
    }
}

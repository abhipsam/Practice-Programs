import java.util.*;

public class InsertInterval {
    //Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> resultList=new ArrayList<>();
        if(intervals.size()==0){
            resultList.add(newInterval);
            return resultList;
        }

        boolean changed=false;
        for(Interval interval:intervals) {
            Interval curr = interval;
            if(curr.end<newInterval.start){
                resultList.add(curr);
            }else if(curr.start>newInterval.end){
                resultList.add(newInterval);
                newInterval=interval;
            }else{
               if(curr.end >= interval.start  || curr.start <=newInterval.end){
                   int min = Math.min(curr.start, newInterval.start);
                   int max = Math.max(curr.end, newInterval.end);
                   newInterval = new Interval(min, max);
                  // newInterval = curr;
               }
            }
        }
        resultList.add(newInterval);

        Collections.sort(resultList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o2.start!=o1.start){
                    return o1.start-o2.start;
                }else{
                    return o1.end-o2.end;
                }
            }
        });
        return resultList;
    }

    public static void main(String args[]){
        List<Interval> intervalList=new ArrayList<>();
        Interval interval=new Interval(1,2);
        Interval interval1=new Interval(3,5);
        Interval interval2 = new Interval(6,7);
        Interval interval3 =new Interval(8,10);
       Interval interval4 =new Interval(12,16);
         //Interval interval4 =new Interval(1,10);

        intervalList.add(interval);
        intervalList.add(interval1);
        intervalList.add(interval2);
        intervalList.add(interval3);
        intervalList.add(interval4);

        List<Interval> resultList=insert(intervalList,new Interval(4,9));

        for(Interval intervals : resultList){
            System.out.print("("+intervals.start+","+intervals.end+")");
            System.out.println();
        }
    }
}

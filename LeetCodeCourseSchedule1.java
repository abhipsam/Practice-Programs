import java.util.LinkedList;
import java.util.Queue;

public class LeetCodeCourseSchedule1 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
       int n = prerequisites.length;

       if(n==0 || prerequisites==null){
           return false;
       }

       int[] courses = new int[numCourses];
       for(int i=0;i<prerequisites.length;i++){
           courses[prerequisites[i][0]]++;
       }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<courses.length;i++){
            if(courses[i]==0){
                queue.add(i);
            }
        }

        int count=queue.size();

        while(!queue.isEmpty()){
           int x = queue.remove();
           for(int i=0;i<n;i++){
               if(prerequisites[i][1]==x){
                   courses[prerequisites[i][0]]--;
                   if(prerequisites[i][0]==0){
                       queue.add(prerequisites[i][0]);
                       count++;
                   }
               }
           }
        }

        return (count==numCourses);
    }

    public static void main(String args[]){
       int[][] prerequisistes={{0,1}};
       int n=2;
       System.out.println(canFinish(n,prerequisistes));
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] result = new int[numCourses];

        if(numCourses==0){
            return result;
        }
        if(n==0){
          for(int i=0;i<numCourses;i++){
              result[i]=i;
          }
          return result;
        }


        int[] courses = new int[numCourses];

        for(int i=0;i<n;i++){
            courses[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(courses[i]==0){
                queue.add(i);
            }
        }
        int count=queue.size();
        int j=0;
        while(!queue.isEmpty()){
            int x = queue.remove();
            result[j]=x;
            j++;

            for(int i=0;i<n;i++){
                if(prerequisites[i][1]==x){
                    courses[prerequisites[i][0]]--;
                    if(courses[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                        count++;
                    }
                }
            }
        }

      return count==numCourses?result:new int[0];
    }

    public static void main(String args[]){
        int[][] courses = {};
        int[] result = findOrder(3,courses);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}

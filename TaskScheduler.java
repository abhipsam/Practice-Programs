import java.util.*;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }

        Arrays.sort(map);
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                time++;

                if (queue.isEmpty() && temp.size() == 0) {
                    break;
                }
                i++;
            }
                    for (int p : temp) {
                        queue.add(p);
                    }
                }

        return time;
    }

    public static void main(String args[]){
        char[] tasks={'A','A','B','B','B','A'};
        int n=2;

        System.out.println(leastInterval(tasks,n));
    }

}

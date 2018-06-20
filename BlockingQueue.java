import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    public Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public BlockingQueue(int limit){
        this.capacity=limit;
    }

    public synchronized void enqueue(Integer integer) throws InterruptedException{
         if(this.queue.size()==this.capacity){
             wait();
         }if(this.queue.size()==0){
            notifyAll();
         }
             queue.add(integer);
    }

    public synchronized Integer dequeue() throws InterruptedException{
        if(queue.isEmpty()){
            wait();
        }
        if(queue.size()==this.capacity){
            notifyAll();
        }
        return queue.remove();
    }


}

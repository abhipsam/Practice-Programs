import java.util.*;

public class LRUCache {
    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key=key;
            this.value=value;
            this.prev = null;
            this.next = null;
        }
    }

    static HashMap<Integer, Node> hashMap = new HashMap<>();
    static int capacity;
    static Node head = null;
    static Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        } else {
            Node node = hashMap.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }

    }

    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
           Node node = hashMap.get(key);
           node.value=value;
           remove(node);
           setHead(node);
       }else{
            Node newNode = new Node(key,value);
          if(hashMap.size()==capacity){
              hashMap.remove(end.key);
              remove(end);
              setHead(newNode);
          }else{
              setHead(newNode);
          }
          hashMap.put(key,newNode);
       }
    }

    public void setHead(Node node) {
        node.next=head;
        node.prev=null;

        if(head!=null){
            head.prev=node;
        }
        if(end==null){
            end=head;
        }
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        if(prev!=null){
            prev.next=next;
        }else{
            head=next;
        }

        if(next!=null){
            next.prev=prev;
        }else{
            end=prev;
        }
    }
}


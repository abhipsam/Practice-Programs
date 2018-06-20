public class TestLRUCACHE {
    public static void main(String args[]){
        LRUCache cache = new LRUCache(3);
       cache.put(1, 1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println( cache.get(4));
        System.out.println(cache.get(3));
        cache.get(2);
        cache.get(1);// evicts key 2
        cache.put(5,5);    // evicts key 1
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println( cache.get(4));
        System.out.println( cache.get(5));

        System.out.println(cache.get(5));
    }



}

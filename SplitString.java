import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SplitString {
    public static List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> resultList=new LinkedList<>();
        if(s==null){
            return resultList;
        }
        if(s.length()==0){
            resultList.add(new ArrayList<String>());
        }

        splitStringHelper(s,0,resultList,new LinkedList<>());

        return resultList;

    }

    public static void splitStringHelper(String str, int i , List<List<String>> lists,List<String> curr) {
        // write your code here

        if(i>=str.length()){
            lists.add(new ArrayList<String>(curr));
            return;
        }

        for(int j =i;j<i+2 && j<str.length();j++){
            String substring= str.substring(i,j+1);
            curr.add(substring);
            splitStringHelper(str,j+1,lists,curr);
            curr.remove(curr.size()-1);
        }

    }

    public static void main(String args[]){
        String str ="123";
        List<List<String>> resultList = splitString(str);
        for(List<String> strings:resultList){
            System.out.println();
            for(String string:strings){
                System.out.print(string+" ");
            }
        }
    }
}

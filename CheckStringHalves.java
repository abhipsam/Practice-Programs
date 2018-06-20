import java.util.HashMap;

public class CheckStringHalves {
    public static boolean checkStringHalves(String string){
        int n = string.length();
        int end =0;
        if(n%2==0){
            end = n/2;
        }else{
            end = (n/2)+1;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i=0;i<end;i++){
            Character x = string.charAt(i);
            if(!hashMap.containsKey(x)){
                hashMap.put(x,1);
            }else {
                hashMap.put(x,hashMap.get(x)+1);
            }

        }

        for(int i=end;i<n;i++){
            Character y = string.charAt(i);
            if(hashMap.containsKey(y)){
                hashMap.put(y,hashMap.get(y)-1);
            }else{
                return false;
            }
        }

        for(Character character:hashMap.keySet()){
            if(!(hashMap.get(character)==0)){
                return false;
            }
        }
      return true;
    }

    public static void main(String args[]){
        String string = "abccabv";
        if(checkStringHalves(string)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}

import java.util.HashMap;

/* I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.*/
public class RomanToInteger {
    static public int romanToInt(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);

        int num =0;
        char prev=' ';

        for(int i=0;i<s.length()-1;i++) {
            int x = hashMap.get(s.charAt(i));
            int y = hashMap.get(s.charAt(i+1));

            if(y>x){
                num=num-x;
            }else {
                num = num + x;
            }
        }
        num=num+hashMap.get(s.charAt(s.length()-1));
        return num;

    }

    public static void main(String args[]){
        String string=  "MCMXCIV";
        System.out.print(romanToInt(string));

    }
}

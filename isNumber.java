import java.util.HashSet;

public class isNumber {
    public static boolean isNumber(String s) {
        int n=s.length();

        if(n==0 || s==" "){
            return false;
        }

        boolean isNum=false;
        int space=-1;
        int exp=-1;
        int num=0;
        int dec=-1;
        for(int i=0;i<n;i++){
            Character x = s.charAt(i);
            if(x >='0' && x<='9'){
                isNum=true;
             }else if(x==' '){
                 space=i;
             }
             else if(x.equals('e') || x.equals('E')){
                 if(i==0 || i-1==space){
                     return false;
                 }else {
                     exp= i;
                 }
                num=num+1;
             }
             else if(x.equals('.')){
                dec=i;
                num=num+1;
             }
             else if(x.equals('+') || x.equals('-')){
                 if(i!=0 && i-1!=exp){
                     return false;
                 }
             }
             else{
                 return false;
             }
        }
        if(num>1){
            return false;
        }
        if(exp==n-1){
            return false;
        }
        if(space!=-1 && !isNum){
           return false;
        }
        if(dec!=-1 && !isNum){
            return false;
        }
        return isNum;
    }

    public static void main(String args[]){
        String string=". ";

        System.out.println(isNumber(string));
    }
}

import java.util.HashMap;

public class StrongPasswordChecker {
    public static int strongPasswordChecker(String s) {
       int n = s.length();
       int change = 0;

       int missingType =3;
       boolean isLower= false;
       boolean isUpper = false;
       boolean isDigit = false;

       if(n>20 || n<6){
          if(n>20){
              change=change + (n-20);
          }else if (n<6){
             change=change+(6-n);
          }
       }
       char[] str = s.toCharArray();
        for(char c: str)
        {
            if(!isUpper && Character.isUpperCase(c)) { isUpper = true; missingType-=1; } //uppercase
            if(!isLower && Character.isLowerCase(c)) { isLower = true; missingType-=1; } //lowercase
            if(!isDigit && Character.isDigit(c)) { isDigit = true; missingType-=1; } //atleast one number

        }

        // No repeating sets of characters
        int totalChangeCnt = 0, OneChangeCnt =0, TwoChangeCnt =0, pos=2;

        while(pos<str.length){
            if(str[pos]==str[pos-1] && str[pos-1]==str[pos-2] && str[pos]==str[pos-2]){
                int length=2;
                //how many multiples of 3 characters are there

                while(str[pos]==str[pos-1]){
                    length=length+1;
                    pos=pos+1;

                    totalChangeCnt= length/3;
                    if(length%3==0){
                        OneChangeCnt=OneChangeCnt+1;
                    }
                    if(length%3==1){
                        TwoChangeCnt=TwoChangeCnt+1;
                    }
                }
            }else{
                pos=pos+1;
            }
        }






















        while(pos < s.length())
        {
            if(str[pos]==str[pos-1] && str[pos-1]==str[pos-2] && str[pos-2]==str[pos])
            {
                int length = 2;
                while(pos < s.length() && str[pos]==str[pos-1])
                {
                    length += 1; pos +=1;
                }
                totalChangeCnt += length/3;
                if(length%3==0) OneChangeCnt += 1;
                else if(length%3==1) TwoChangeCnt += 1;

            }
            else
            {
                pos=pos+1;
            }
        }

       return change;
    }

    public static void main(String args[]){
        String x = "aaabC1";
        System.out.println(strongPasswordChecker(x));
    }
}

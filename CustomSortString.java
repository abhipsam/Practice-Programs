public class CustomSortString {
    public static String customSortString(String S, String T) {

        int[] chars = new int[26];
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder initial = new StringBuilder();

        for(int i=0;i<T.length();i++){
            chars[T.charAt(i)-'a']++;
        }

        for(int j=0;j<S.length();j++){
            if(chars[S.charAt(j)-'a']>0){
                while(chars[S.charAt(j)-'a']>0){
                    stringBuilder.append(S.charAt(j));
                    chars[S.charAt(j)-'a']--;
                }
            }
        }

        for(int i=0;i<T.length();i++){
            if(chars[T.charAt(i)-'a']>0){
                while(chars[T.charAt(i)-'a']>0){
                    initial.append(T.charAt(i));
                    chars[T.charAt(i)-'a']--;
                }
            }
        }

       return stringBuilder.append(initial).toString();
    }

    public static void main(String args[]){
        String S="cba";
        String T="abcd";
        System.out.println(customSortString(S,T));
    }
}

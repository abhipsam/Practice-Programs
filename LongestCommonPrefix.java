public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        StringBuilder stringBuilder = new StringBuilder();

        if(n==0 || strs==null){
            return stringBuilder.toString();
        }

        int min=Integer.MAX_VALUE;
        int index=-1;

        for(int i=0;i<n;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
                index=i;
            }
        }


        String string=strs[index];
        for(int i=0;i<min;i++){
            for(int j=0;j<n;j++){
                if(string.charAt(i)==strs[j].charAt(i)){
                    continue;
                }else{
                    stringBuilder.append(string.substring(0,i));
                    return stringBuilder.toString();
                }
            }
        }
     return stringBuilder.toString();
    }
    public static void main(String args[]){
        String[] strings= {"flower","flow","flight"};
        System.out.println("The longest common prefix="+longestCommonPrefix(strings));
    }
}

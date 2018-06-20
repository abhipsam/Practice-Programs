import java.util.ArrayList;
import java.util.List;

public class PascalTirangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();

        int[][] result = new int[numRows][numRows];

        for(int i=0;i<numRows;i++){
            result[i][0]=1;
            result[i][i]=1;
        }

        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(result[i][j]==0){
                    if(j>i){
                        break;
                    }else{
                        result[i][j] = result[i-1][j] + result[i-1][j-1];
                    }
                }
            }
        }

        for(int i=0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(result[i][j]!=0){
                   temp.add(result[i][j]);
                }
            }
            resultList.add(temp);
        }

        return resultList;
    }

    public static void main(String args[]){
        List<List<Integer>> result = generate(4);

        for(List<Integer> list:result){
            System.out.print(list);
        }
    }
}

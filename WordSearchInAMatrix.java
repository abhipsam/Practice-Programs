public class WordSearchInAMatrix {
     static boolean[][] visited;

     public static boolean exist(char[][] board, String word){
         visited=new boolean[board.length][board[0].length];
         if(board.length==1){
             if(word.length()>board[0].length){
                 return false;
             }
         }else if(board[0].length==1){
             if(word.length()>board.length){
                 return false;
             }
         }
      for(int i=0;i<board.length;i++){
          for(int j=0;j<board[0].length;j++){
              if(exists(board,word,0,i,j)){
                  return true;
              }
          }
      }
       return false;
    }

    public static boolean exists(char[][] board, String word, int index, int x, int y){
        if(index==word.length()){
            return true;
        }
        if(x<0 || y<0 || x>=board.length||y>=board[0].length || visited[x][y]){
            return false;
        }
        if(board[x][y]!=word.charAt(index)){
            return false;
        }

           visited[x][y]=true;
            if(exists(board,word,index+1,x,y+1) || exists(board,word,index+1,x+1,y)
                    || exists(board,word,index+1,x-1,y)||exists(board,word,index+1,x,y-1)){
                return true;
            }
            visited[x][y]=false;
            return false;
    }

    public static void main(String args[]){
         char[][] chars ={{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};


         String word ="ABCB";
         if(exist(chars,word)) {
             System.out.println("true");
         }else{
             System.out.println("false");
         }
    }
}

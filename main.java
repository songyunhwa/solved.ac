
import java.io.*;
import java.util.*;
class Main {
  public static int[][] dir = {{-1,0}, { 1,0}, {0, 1}, {0,-1}};
  public static char[][] arr;
  public static int     answer =0 ;
  public static ArrayList<line> list = new ArrayList<>();
  public static class line{
    int x;
    int y;
    public line(int x ,int y){
      this.x= x;
      this.y = y;
    }
  }
  //R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
  public static void bfs(int i, int j){
    Queue<line> q = new LinkedList<>();
    q.add(new line(i, j));
    list.add(new line(i, j));
    int[][] visit = new int[12][6];
    while(!q.isEmpty()){
      line f=  q.poll();
      visit[f.x][f.y] = 1;

      for(int k=0; k< 4; k++){
        int x = f.x +dir[k][0];
        int y = f.y + dir[k][1];
        if(x >=0 && x < 12 && y>=0 && y<6){
          if(visit[x][y] == 0 && arr[x][y] == arr[f.x][f.y]){
          line l = new line(x, y);
            q.add(l);
            if(!list.contains(l))
          list.add(l);    
          }
        }
      }
    }
  
  }
  public static void move_down(){
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                if (arr[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (arr[k][i] != '.') {
                            arr[j][i] = arr[k][i];
                            arr[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    arr =new char[12][6];
    for(int i=0; i<12; i++){
      String s = br.readLine();
      for(int j=0; j<6; j++){
      arr[i][j] = s.charAt(j);
     }
   }

   while(true){
   boolean ch = false;
   for(int i=0; i<12; i++){
    for(int j=0; j<6; j++){
      if(arr[i][j] != '.'){
        bfs(i, j);
        ch = true;
        if(list.size() >= 4){
          for(int k=0; k<list.size(); k++){
            line f= list.get(k);
            arr[f.x][f.y] = '.';
          }
            list.clear();
            move_down();
            answer++;
        }
      }
    }
    }
    if(!ch){
      break;
    }
  }
  System.out.println(answer);
  }
} 
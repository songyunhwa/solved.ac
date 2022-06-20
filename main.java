
import java.io.*;
import java.util.*;
class Main {
  public static int m;
  public static int n;
  public static int[][] arr;
  public static int[][][] visited;
  public static int count = Integer.MAX_VALUE;
  public static int[][] dir= {{-1, 0} , {1, 0}, {0, 1}, {0, -1}};
  public static class line{
    int x;
    int y;
    int cnt;
    public line(int x, int y, int cnt){
      this.x = x;
      this.y =y;
      this.cnt = cnt;
    }
  }
  public static int dfs(){
    Queue<line> q = new LinkedList<>();
    q.add(new line(0, 0, 0));
    visited[0][0][0] = 1; // 개수 세기 위해서

    while(!q.isEmpty()){
      line f = q.poll();

      if(f.x == m-1 && f.y ==n-1) {
        return visited[f.x][f.y][f.cnt];
      }
      for(int i=0; i< 4; i++){
        int x = f.x + dir[i][0];
        int y = f.y + dir[i][1];

        if(x >=0 && x<m && y>=0 && y<n){
          if(arr[x][y] == 1 && f.cnt == 0){
            // 1일때 몇개인지
            visited[x][y][1] = visited[f.x][f.y][0] + 1;
            q.add(new line(x, y,  f.cnt+1));
          }
          if(arr[x][y] == 0 && visited[x][y][f.cnt] == 0 ){
            // 0 일때 방문하지 않고 몇개인지
            visited[x][y][f.cnt] = visited[f.x][f.y][f.cnt] + 1;
            q.add(new line(x, y, f.cnt));
          }
        }
      }
    }
    return -1;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");

    m = Integer.parseInt(str[0]);
    n = Integer.parseInt(str[1]);
    arr =new int[m][n];
    visited = new int[m][n][2];
    for(int i=0;i<m; i++){
      str = br.readLine().split("");
      for(int j=0; j<n; j++){
        arr[i][j] = Integer.parseInt(str[j]);
      } 
    }

    System.out.println(dfs());

  }
} 
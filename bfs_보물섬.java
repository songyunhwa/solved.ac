public class bfs_보물섬 {
     // 처음에는 check를 기억하며 bfs 해주도록 했는데
  // 그러면 틀림.
  // 각 모든 땅마다 bfs를 해주기 위해서 초기화가 필요.
  public static  int max = 0;
  public static class line{
    int x; 
    int y;
    public line(int x, int y){
      this.x= x;
      this.y= y;
    }
  }
  public static void bfs(int[][] arr, Queue<line> q){
    int[][] dir = {{-1, 0}, {1,0},{0,1}, {0, -1}};
    int[][] check = new int[arr.length][arr[0].length];
    check[q.peek().x][q.peek().y] = 1; // check 를 여기서 초기화해줘야 안 틀림.

    while(!q.isEmpty()){
      line now =q.poll();
      for(int i=0; i<4; i++){
        int x= now.x+ dir[i][0];
        int y= now.y+ dir[i][1];
        if(x>=0 && x<arr.length && y>=0 && y<arr[0].length){
          if(arr[x][y] == 1&& check[x][y] == 0){
         
              check[x][y] = check[now.x][now.y]+1;
              max = Math.max(check[x][y], max);
              q.add(new line(x, y));
            

          }
        }
      }
    }

  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

      
      String[] strs = br.readLine().split(" ");
      int n = Integer.parseInt(strs[0]);
      int m = Integer.parseInt(strs[1]);
      int[][] arr = new int[n][m];
      for(int i=0; i<n; i++){
        String str = br.readLine();
        for(int j=0; j<m; j++){
          if(str.substring(j,j+1).equals("L"))
          arr[i][j] = 1;
        }
      }
      Queue<line> q= new LinkedList<>();

      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(arr[i][j] == 1){

            q.add(new line(i,j));
            bfs(arr, q);

          }
        }
      }

      System.out.println(max-1);
  }
}

public class bfs_인구이동 {
     //https://www.acmicpc.net/problem/16234
  public static class Node{
    int x;
    int y;
    public Node(int x, int y){
      this.x=x;
      this.y=y;
    }
  }
  public static ArrayList<Node> list =new ArrayList<>();
  public static int sum =0;
  public static int n=0;

   public static boolean bfs(int[][] arr, int x, int y){
    Queue<Node> q = new LinkedList<Node>();
    q.add(new Node(x, y));
    int[][] dir ={{-1, 0}, {1,0} ,{0, 1}, {0, -1}};  

    while(!q.isEmpty()){
        Node now = q.poll();
        for(int a=0; a<4; a++){
          int i = now.x + dir[a][0];
          int j = now.y + dir[a][1];

          if(i >=0 && i<arr.length & j>=0 && j<arr[0].length){
            if(Math.abs(arr[now.x][now.y] - arr[i][j]) >= l && 
            Math.abs(arr[now.x][now.y] - arr[i][j]) <= r){
              list.add(now);
              sum += arr[now.x][now.y];
              n++;
              bfs(arr, now.x, now.y);
            }
          }
        }
      }

      if(sum > 0){
        return true;
      }else return false;
   }
   public static int l;
   public static int r;
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      String[] strs = br.readLine().split(" ");
      int n = Integer.parseInt(strs[0]); 
      l = Integer.parseInt(strs[1]); 
      r = Integer.parseInt(strs[1]); 

      int[][] arr =new int[n+1][n+1];
      for(int i=0; i<n; i++){
        strs = br.readLine().split(" ");
        for(int j=0; j<n; j++){
          arr[i][j] = Integer.parseInt(strs[j]);
        }
        }
        boolean change= true;
        int result = 0;
        while(change){
        
          for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
             
              if(!bfs(arr, i, j)){ // 바꿨다면
                change = false;
              }
            }
          }
          if(change){
            for(int i=0; i<list.size(); i++){
              Node now = list.get(i);
              arr[now.x][now.y] = sum/n;
            }

            result++;
          }
        }

      System.out.println(result);
    }

}

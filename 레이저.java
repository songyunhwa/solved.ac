public class 레이저 {
    // 백트래킹 안 되서 당황타다가 new 로 배열 복사해서 큐에 넣으니까 됨
    // 보텅 bfs 일때 답 넣을때 return 쓰지 말기. 
    // 문제좀 기억하자... 막 풀지 말고.

    public static int result =0;
    public static int n=0;
      public static int k=0;
          public static int m=0;
  
      public static class line{
          int cnt;
          int[] a;
  
          int v;
          public line(int cnt ,int[] a, int v){
              this.cnt=cnt;
              this.a= a;
              this.v= v;
          }
  
      public void change(int i){
        this.a[i] -=1;
      }
      public void addchange(int i){
        this.a[i] +=1;
      }
      }
      public static void dfs(int[][] arr) {
          Queue<line> q= new LinkedList<line>();
      int[] arr1 = new int[n];
      for(int i=0; i<n; i++){
        arr1[i] = m;
      }
  
          q.add(new line(0, arr1, 0));
          while(!q.isEmpty()){
              line now = q.poll();
        int cnt = now.cnt;
        int v = now.v;
        arr1 = now.a;
  
        if(cnt == k){
          result =  Math.max(result, v);
        }
      
        for(int i=0; i<n; i++){
          if(arr1[i]-1>=0){
            int[] arr2 = new int[n];
            for(int j=0; j<n; j++){
              arr2[j]= arr1[j];
            }
            arr2[i] -=1;
  
            int v1 =0;
            for(int j=0; j<n; j++){
              v1+=arr[j][arr2[j]];
            }
            line n = new line(cnt+1, arr2, v1);
            q.add(n);
          }
        }
  
          }
  
      }
      public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String[] input = br.readLine().split(" ");
          
       n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
          k = Integer.parseInt(input[2]);
          
          int[][] arr =new int[n+1][m+1];
          for(int i=0; i<n; i++){
              input = br.readLine().split(" ");
              for(int j=0; j<m; j++){
                  arr[i][j] = Integer.parseInt(input[j]);
              }
          }
          dfs(arr);
          System.out.println(result);
      }
}

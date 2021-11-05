public class bfs_스타트링크 {
    public static class line{
        int go;
        int v;
        public line(int go, int v){
          this.go= go;
          this.v = v;
        }
      }
        public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    
            
            String[] strs = br.readLine().split(" ");
            int F = Integer.parseInt(strs[0]);
            int S = Integer.parseInt(strs[1]);
            int G = Integer.parseInt(strs[2]);
            int U = Integer.parseInt(strs[3]);
            int D = Integer.parseInt(strs[4]);
            if(S==G){
              System.out.println(0);
              return;
            }
            Queue<line> q = new LinkedList<>();
            q.add(new line(S, 0));
            int[] dp = new int[F+1];
            for(int i=0; i<=F; i++)
              dp[i] = Integer.MAX_VALUE;
            
              while(!q.isEmpty()){
              line now = q.poll();
              if(now.go+U<=F)
                if(dp[now.go+U] > now.v+1){
                  dp[now.go+U]= now.v+1;
                  q.add(new line(now.go+U, now.v+1));
                }
              if(now.go-D>0) // 0은 가면 안되는데 넣어서 틀렸었음.
                if(dp[now.go-D] >now.v+1){
                  dp[now.go-D] = now.v+1;
                  q.add(new line(now.go-D, now.v+1));
                }
            }
            if(dp[G] != Integer.MAX_VALUE)
            System.out.println(dp[G]);
            else System.out.println("use the stairs");
        }
    
}

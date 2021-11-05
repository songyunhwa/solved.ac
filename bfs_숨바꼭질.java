public class bfs_숨바꼭질 {
    public static class line implements Comparable<line>{
        int go; 
        int time;
        public line(int go, int time){
          this.go = go;
          this.time = time;
        }
        @Override
        public int compareTo(line o){
          if(o.time > this.time){
            return 1;
          }else return -1;
        }
      }
      public static int result =Integer.MAX_VALUE;
      public static int k = 0;
      public static int[] visit;
      public static void dfs(int t , int x){
        Queue<line> q = new LinkedList<>();
        q.add(new line(x,t));
        while(!q.isEmpty()){
          line now = q.poll(); 
          x=  now.go;
          t = now.time;
          if(x == k){
            result = Math.min(result , t);
            return;
          }
         
            if(t > result) return;
            /// 곱하기가 뒤에 가면 틀림.
            if(x*2<=100000 && visit[x*2] > t){
              visit[x*2] = t;
              q.add(new line(x*2, t));
            }
            if(x-1>=0 && visit[x-1] > t+1){
              visit[x-1] = t+1;
              q.add(new line(x-1, t+1));
            }
            if(x+1<=100000 && visit[x+1] > t+1){
              visit[x+1] = t+1;
              q.add(new line(x+1, t+1));
            }
  
        }
        
        
      }
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        visit = new int[100001];
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[n] = 1;
        dfs(0, n);
        System.out.println(result);
        
      }
  
}

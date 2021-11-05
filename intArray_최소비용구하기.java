public class intArray_최소비용구하기 {
    public static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        public Node(int to, int cost) {
          this.to = to;
          this.cost = cost;
        }
      
        @Override
        public int compareTo(Node o) {
          return this.cost - o.cost;
        }
      }
        public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
          StringTokenizer st = null; 
            
          int n = Integer.parseInt(br.readLine()); 
          int k = Integer.parseInt(br.readLine()); 
          List<Node>[] arr = new ArrayList[n+1];
          for(int i=0; i<=n; i++){
            arr[i] = new ArrayList<>();
          }
          String[] strs;
          for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[a].add(new Node(b, c));
          }
          
    
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          int[] dp = new int[n+1];
          Arrays.fill(dp, Integer.MAX_VALUE);
    
          Queue<Node> q = new LinkedList<Node>();
          q.add(new Node(a, 0));
          dp[a] = 0;
    
          while(!q.isEmpty()){
            Node now = q.poll();
           
            for(Node next: arr[now.to]){
              if(dp[next.to] >  next.cost + dp[now.to] ){
                dp[next.to] =next.cost + dp[now.to];
                q.add(next);
              }
            }
          }
          System.out.println(dp[b]);
        }
}

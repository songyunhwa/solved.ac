public class 16953_A-B(bfs) {
        //https://cocoon1787.tistory.com/378 이분은 그냥 끝자리만 갖고 그리디처럼 푸심
        public static class now{
            int value;
            int cnt;
            public now(int v, int c){
                this.value=v;
                this.cnt = c;
            }
        }
      
        public static void main(String[] args) throws IOException{
    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] strs = br.readLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
    
    
            Queue<now> q= new LinkedList<now>();
            q.add(new now(n*2, 1));
            q.add(new now(n*10+1, 1));
    
            int result = Integer.MAX_VALUE;
    
            if(n==m) result =1;
            else
            while(!q.isEmpty()){
                now front = q.poll();
                if(front.value == m){
                    result = Math.min(result, front.cnt);
                    break;
                }
                if(front.value>m) continue;
                q.add(new now(front.value*2 , front.cnt+1));
                q.add(new now(front.value*10+1, front.cnt+1));
            }
    
            if(result == Integer.MAX_VALUE)
            System.out.println(-1);
            else System.out.println(result+1);
       
    
        }
        
}

public class 이중배열_최단경로 {
    public static class line{
        int v;
        int w;
        public line(int v, int w){
            this.v= v;
            this.w= w;
        }
    }
    public static int[] dp;
    public static void go(int x, ArrayList<ArrayList<line>> arr){
        for(int j=0; j<arr.get(x).size(); j++){
        line now = arr.get(x).get(j); // x 에서 j 로 갈때 최소값 갱신
        if(dp[now.v] > dp[x] + now.w){
            dp[now.v] =   dp[x]  + now.w;
            go(now.v, arr);
        }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<line>> arr = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
        }
    for(int i=0; i<m; i++){
        strs = br.readLine().split(" ");
        int u = Integer.parseInt(strs[0]);
        int v = Integer.parseInt(strs[1]);
        int w = Integer.parseInt(strs[2]);

        arr.get(u).add(new line(v, w));
    }
        dp = new int[n+1];
        for(int j=0; j<=n; j++) dp[j] = 10;
        dp[1] = 0;

        go(start, arr);
        
        for(int j=1; j<=n; j++){
            if(j==start) System.out.println("0");
            else if(dp[j] == 10){
                System.out.println("INF");
            }else System.out.println(dp[j]);
        }
        
    } 

}

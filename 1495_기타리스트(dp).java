// 처음에 bfs로 풀려고 했는데 dp가 훨씬 간단했음.
public class 1495_기타리스트(dp) {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int s = Integer.parseInt(strs[1]);
        int m = Integer.parseInt(strs[2]);

        int[] v= new int[n+1];
        strs = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            v[i+1] =  Integer.parseInt(strs[i]);
        }
        int[][] dp = new int[n+1][m+1];
        dp[0][s] = 1;
        for(int i=1; i<=n; i++){// 순서
            for(int j=0; j<=m; j++) { // 숫자
        
                if(dp[i-1][j] == 1){
                    if(j+v[i] <=m)
                    dp[i][j+v[i]] = 1;
                    if(j-v[i]>=0)
                    dp[i][j-v[i]] = 1;
                }
               
            }
        }
        for(int i=m; i>=0; i--){
            if(dp[n][i] == 1) {
            System.out.println(i);
            return;
            }
        }
        System.out.println(-1);
    }
}

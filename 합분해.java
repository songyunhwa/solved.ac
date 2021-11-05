public class 합분해 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]); 
        int k = Integer.parseInt(strs[1]); 
     
        int[][] dp = new int[k+1][n+1]; // 몇번 더해서 (k) n 이 되었느냐.
        for(int i=1;i<=k;i++) {
          dp[i][0]=1;
        }
        for(int i=1;i<=k;i++) {
          for(int j=1;j<=n;j++) {
            dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000; 
          }
        }
        System.out.println(dp[k][n]);
      }
  

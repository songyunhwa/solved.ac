public class 11057_오르막수(dp) {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
   
        int[][] dp = new int[n+1][10];
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n ; i++){
            dp[i][0] = 1;
            for(int j=0; j<10; j++){
                if(j>=1)
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) %10007;
                else
                dp[i][j] = dp[i-1][j]%10007;
            }
        }

        int result = 0;
        for(int j=0; j<10; j++){
            result += dp[n][j];
        }
        System.out.println(result%10007);
    }
    
}

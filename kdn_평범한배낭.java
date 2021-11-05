public class kdn_평범한배낭 {
    
    //틀림
    // //ksnap알고리즘
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String[] strs = br.readLine().split(" "); 
        int n = Integer.parseInt(strs[0]); 
        int m = Integer.parseInt(strs[1]); 
  
        int[][] dp = new int[n][m+1];
        int[] w = new int[m+1];
        int[] v = new int[m+1];
        for(int j=0; j<n; j++){
          strs = br.readLine().split(" "); 
          w[j]= Integer.parseInt(strs[0]); // 무게 
          v[j] = Integer.parseInt(strs[1]); // 가치
        }
  
        for(int j=1; j<n; j++){
          for(int k=1; k<=m ;k++){
              dp[j][k] = dp[j-1][k];
      
              if(k-w[j]>=0)
                  dp[j][k] = Math.max(dp[j][k], dp[j][k-w[j]] + v[j]);
          
          }
        }
  
        System.out.println(dp[n-1][m]);
      
      }
  
  
}

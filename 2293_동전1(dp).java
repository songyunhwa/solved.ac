public class 2293_동전1(dp) {
   

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        int[] dp = new int[k+1];
        int[] arr =new int[n];
        for(int i=0; i<n; i++){
            int now = Integer.parseInt(br.readLine());
            arr[i] = now;
        }
        dp[0] = 1; // 선택 x

        for(int i=0; i<n; i++){
            for(int j=arr[i]; j<=k; j++){
                dp[j]= dp[j] + dp[j-arr[i]]; // 현재 동전을 선택한 경우/
            }
        }
        System.out.println(dp[k]);
        
    }
    

}

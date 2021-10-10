// 실패 코드

public class 동전2(dp) {
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
        
        for(int i=0; i<=k; i++) {
            dp[i]= Integer.MAX_VALUE;
        }
        dp[0] = 0; // 선택 x

        for(int i=0; i<n; i++){
            for(int j=arr[i]; j<=k; j++){
                   dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1); // 현재 동전을 선택한 경우/
            }
        }
        System.out.println(dp[k]);
        
    }
    
}

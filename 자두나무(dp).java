public class 자두나무(dp) {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int t = Integer.parseInt(strs[0]);
        int w = Integer.parseInt(strs[1]);

        int[][][] dp = new int[t+1][3][w+2];
       
       
        for(int i=1; i<=t; i++){
            int now = Integer.parseInt(br.readLine());
            for(int j=1;j<=w+1; j++){ // 이동하지 않은 것도 생각해줘야함.
                if(now==1) { // 1일때
                dp[i][1][j] = Math.max(dp[i-1][1][j]+1, dp[i-1][2][j-1]+1);
                dp[i][2][j]= Math.max(dp[i-1][1][j-1]  , dp[i-1][2][j]); 
                }
                if(now==2){// 2일떄
                    if(i==1&&j==1) continue; // 첫번째 순서이고 2를 받았을 때에는 움직일 수 없기에 넘기기
                    dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][2][j-1]);
                dp[i][2][j]= Math.max(dp[i-1][1][j-1]+1 , dp[i-1][2][j]+1);  
                }  
            }
            
        }
        int result =0;
        for(int i=1; i<=w+1; i++)
            result = Math.max(dp[t][1][i] ,dp[t][2][i] ); // 마지막 순서 // 1/2 선택 // 이동한 갯수 
        System.out.println(result);

    }
}

import java.io.*;
class Main {
  
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[(123456*2) +1];
        while(true) {
        int cnt = Integer.parseInt(br.readLine());
        if(cnt == 0) break;
        
        if(cnt == 1) {
            System.out.println(1);
            continue;
        }

        dp[0] = 1;
        dp[1] = 1;
        
  
            for(int i=2; i<=cnt*2; i++) {
                if(dp[i] == 0)
                for(int j=i+i; j<=cnt*2; j+=i) {
                    dp[j] = 1;
                }
            }
    

        int result =0;
        for(int i=cnt+1; i<=cnt*2; i++) {
            if(dp[i]== 0) {
                result++;
            }
        }
        System.out.println(result);
       }
    }
}


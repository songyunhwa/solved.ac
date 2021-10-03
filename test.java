// 왜 틀렸는지 모르겠음...
import java.util.*;
import java.io.*;
class test {

    public static void main(String[] args) throws IOException{
        int answer =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String str = br.readLine();
        int n = Integer.parseInt(str);
        // 5원짜리와 2원짜리밖에 없음. dp 로 풀어야 할 거 같은 느낌쓰...

        int[] dp = new int[n+1];
        dp[1] =0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 2;
       for(int t=5; t<=n; t++){
           if(t%5 == 0) dp[t] = t/5;
           else {
               if(dp[t-5] ==0) dp[t] = dp[t-2]+1;
               else if(dp[t-2] ==0 )dp[t] = dp[t-5]+1;
               else
                dp[t] = Math.min( dp[t-5] +1 , dp[t-2] + 1);
           }
  
       }
       System.out.println(dp[n]);
     
    }
}


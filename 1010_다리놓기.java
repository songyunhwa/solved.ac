import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String line = br.readLine();
       for(int i=0; i<Integer.parseInt(line); i++) {
        String line1 = br.readLine();
        String[] str = line1.split(" ");

        int a= Integer.parseInt(str[0]);
        int b= Integer.parseInt(str[1]);

        int[][] dp = new int[b+1][a+1];
        for(int j=1;j<=b; j++){
            dp[j][0] = 1;
        }
        
        for(int j=1; j<=b; j++){
            for(int t=1; t<=a; t++) {
                if(j==t) dp[j][t] = 1;
                else dp[j][t] = dp[j-1][t-1] + dp[j-1][t];
            }
        }
        System.out.println(dp[b][a]);
       }
    }
}

public class 1로만들기2(dp) {
    
    public static void print(int[] dp, int n) {
        System.out.print(n+ " ");

        if(n==1){
            return;
        }
        if(n-1>=0 && dp[n]-1 == dp[n-1]){
            print(dp, n-1);
        }
        else if(n%3==0 && dp[n]-1 == dp[n/3]){
            print(dp, n/3);

        }
        else if(n%2 == 0&& dp[n]-1 ==dp[n/2]){
            print(dp, n/2);

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int in = Integer.parseInt(br.readLine());
        int[] dp = new int[in+1];
        for(int i=1; i<=in; i++){
            dp[i] = 1000000;
        }
    
        dp[1] = 0;
        for(int i=1; i<=in; i++){
            if(i*3 <=in){
                if(dp[i*3] > dp[i]+1){
                    dp[i*3]= dp[i]+1;
                }
            }
            if(i*2 <=in){
                if(dp[i*2] > dp[i]+1){
                    dp[i*2]= dp[i]+1;
                }
            }
            if(i+1 <=in){
                if(dp[i+1] > dp[i]+1){
                    dp[i+1]= dp[i]+1;
                }
            }
        }
        System.out.println(dp[in]);
        print(dp, in);

        return;
    }

}

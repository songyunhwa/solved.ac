import java.util.*;
import java.io.*;
class Main {
   
    class line implements Comparable<line>{
         int a;
         int b;
        public line(int a, int b){
             this.a=a;
             this.b=b;
         }
         @Override
         public int compareTo(line o) {
            if(this.a > o.a){
                return 1; // 시작하는 수 오름차순?
            }else return -1;
         }
    }
    public static line[] arr;
    public static int dp[];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       
        dp = new int[n+2];
        arr =new line[n+2];
        for(int i=0; i<n; i++){
            String[] strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            arr[i].a=a;
            arr[i].b=b;
        }
        Arrays.sort(arr);

        int result=0;
        for(int i=0; i<n; i++){
            dp[i] =1;
            for(int j=0; j<i; j++){
                if(arr[i].b > arr[j].b){
                    dp[i] = Math.max(dp[i] , dp[j]+1);
                }
            }
            result = Math.max(result ,dp[i]);
        }
        System.out.println(n-result);
    }
    

}

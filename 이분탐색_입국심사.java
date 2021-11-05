public class 이분탐색_입국심사 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        long[] arr =new long[n];
                for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        long left = 0;
        long right = 10^18;
        long ans =0;
        while(left<=right){
            
            long mid = (left+right)/2;
            int cnt =0;
            for(int i=0; i<n; i++){
                    cnt+=mid/arr[i]; 
                
            }
            if(cnt <m){
                left = mid+1;
              
            }else {
                right = mid-1;
                ans=mid;
            }
        }
        System.out.println(ans);
    }

}

public class 2110_공유기검색(이분탐색) {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int now = Integer.parseInt(br.readLine());
            arr[i] = now;
        }

        Arrays.sort(arr);
        int result =0;
        int low = 0;
        int high = arr[arr.length -1];
        int mid =0;
        while(low <= high){
            mid = (low + high)/2;
            int cur = arr[0];
            int cnt =1;
            for(int i=1; i<n; i++){
                if(arr[i] - cur >= mid) {
                    cur=arr[i];
                    cnt++;
                }
            }

            if(cnt>=k) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        System.out.println(mid);
        
    }
}

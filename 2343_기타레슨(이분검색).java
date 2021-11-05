public class 2343_기타레슨(이분검색) {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        strs = br.readLine().split(" ");
        int[] arr =new int[n];
        int high =0;  // 결과값이 될 수 있는 것중 가장 큰 값
        int low =-1; // 결과값이 될수 있는 것중 가장 작은 값.
        for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(strs[i]);
           high += arr[i];
           low = Math.max(low, arr[i]);
        }

        int mid =0;
        while(low<=high){
            mid = (high + low) /2;
            int sum=0;
            int cnt=0;
            for(int i=0; i<n; i++){
                if(sum+arr[i] >mid){
                    cnt++;
                    sum=0;
                }
                sum+=arr[i];
                
            }
            if(sum > 0) cnt++; // 빼놓고 했음.
            if(cnt <=m){
                high = mid-1;
            }else {
                low = mid +1;
            }
        }
        System.out.println(low); // 최솟값은 low 임.
        return;
    }
}

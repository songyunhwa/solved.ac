public class 16194_카드구매하기2(dp) {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       
        int[] arr = new int[n+1];
        for(int i=0; i<=n; i++)arr[i] = Integer.MAX_VALUE;
        arr[0] = 0;

        String[] strs = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            int now = Integer.parseInt(strs[i-1]);
            arr[i] = now;

            for(int j=1; j<=i; j++){
                arr[i] = Math.min(arr[i] , arr[i-j] + arr[j]);
            }
        }
        System.out.println(arr[n]);
        return;
    }

}

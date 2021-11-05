public class 빗물(브루트) {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int h = Integer.parseInt(strs[0]);
        int w = Integer.parseInt(strs[1]);

        int result =0;
        strs = br.readLine().split(" ");
        int[] arr = new int[w];
        for(int i=0; i<w; i++){
            int now = Integer.parseInt(strs[i]);
            arr[i] = now;
        }

        for(int i=1; i<w-1; i++){
            // 왼쪽 기둥과 오른쪽 기둥에서 작은 것 
            int v = Math.min(max(arr, 0, i-1) , max(arr, i+1, w-1)); 
            if(arr[i] < v) // 현재가 두 기둥보다 클 수 있음.
            result +=(v - arr[i]);
        }
        System.out.println(result);
    }
}

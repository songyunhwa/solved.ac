// StringTokenizer 사용해야 넘어감...
import java.io.*;
import java.util.*;
class 누적합 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arr =new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }
        int[] sum = new int[n];
        for(int j=1; j<n; j++) {
        
            if(arr[j] < arr[j-1])
            sum[j] = sum[j-1] +1;
            else sum[j] = sum[j-1];
            
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            System.out.println(sum[y-1]-sum[x-1]);
        }
    }
    
}


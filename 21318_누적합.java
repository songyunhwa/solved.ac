// StringTokenizer 사용해야 넘어감...
import java.io.*;
import java.util.*;
class 누적합 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arr =new int[n];
        arr[1] = 0;
        arr[2] = 0;
        for(int i=2; i<n; i++){
            if(arr[i] == 0)
            for(int j=i+i; j<n; j+=i) {
                arr[j] =1;
            }
        }
        int[] result = new int[2];
        for(int i=0; i<n; i++) {
            int now = Integer.parseInt(str.nextToken());
            result[0] = 0;
            result[1] = 0;
            for(int j=0; j<n; j++) {
                if(arr[j] == 0 && arr[now-j] == 0) {
                    if(result[1] - result[0] > now-2*j ) {
                        result[1] = now-j;
                        result[0] = j;
                    }
                }
            }
            System.out.println(result[0] + " " + result[1]);
        }
       

       
    }
    
}


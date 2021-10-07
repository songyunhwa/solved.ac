import java.io.*;
class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] arr =new int[10001];
        arr[1] = 0;
        arr[2] = 0;
        for(int i=2; i<=10000; i++){
            if(arr[i] == 0)
            for(int j=i+i; j<=10000; j+=i) {
                arr[j] =1;
            }
        }
        int[] result = new int[2];

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int now = Integer.parseInt(br.readLine());
            result[0] = 0;
            result[1] = now;
            for(int j=1; j<=now; j++) {
                if(arr[j] == 0 && arr[now-j] == 0) {
                    if(now-(2*j) >= 0)
                    if(result[1] - result[0] > now-(2*j) ) {
                        result[1] = now-j;
                        result[0] = j;
                    }
                }
            }
            System.out.println(result[0] + " " + result[1]);
        }
       

       
    }
    
}


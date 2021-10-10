import java.io.*;
import java.util.StringTokenizer;

class 1992_쿼드트리 {
    public static int[][] arr;
    public static int n;
    public static void quoad(int i, int j, int size) {
        int zero = 0;
        int one =0;
        for(int a = i; a<i+size; a++){
            for(int b= j; b<j+size; b++){
                if(arr[a][b]==1) one++;
                else zero++;
            }
        }

        if(zero >0 && one >0) {
            System.out.print("(");
            quoad(i, j, size/2);
            quoad(i, j+size/2, size/2);
            quoad(i+size/2, j, size/2);
            quoad(i+size/2, j+size/2, size/2);
            System.out.print(")");
        }else if(zero>0) { 
            System.out.print("0");
        }else System.out.print("1");
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
         arr =new int[n][n];
        for(int i=0; i<n; i++){
            String strs = br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(strs.substring(j, j+1));
            }
        }

            quoad(0,0, n);
        }
    
    
}


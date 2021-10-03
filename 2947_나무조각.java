// 단편적으로 한번씩만 바꾼다고 생각해서 틀림
// while 문으로 계속 바꾸게 해주자 통과
import java.util.*;
import java.io.*;
class test {
    public static void printArr(int[] arr){
        System.out.println(arr[0] + " "+ arr[1] + " "+arr[2]+" "+arr[3]+" " + arr[4]);
    }
    public static void  transfer(int[] arr){
        while(true) {
            for(int i=0; i<arr.length-1; i++){
                if(arr[i] > arr[i+1]) {
               int c =arr[i+1];
               arr[i+1] = arr[i];
               arr[i] = c;
               printArr(arr);

                }
             }
             if(arr[0] == 1 && arr[1] ==2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5){
                 return;
             }
        }
    }
    public static void main(String[] args) throws IOException{
        int answer =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String s = br.readLine();
        String[] ss = s.split(" ");
        int[] arr= new int[5];
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(ss[i]);
        }
        
        transfer(arr);
    }
}

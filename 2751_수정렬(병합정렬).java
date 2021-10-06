import java.io.*;
import java.util.*;
class test {
    public static int[] result;
    public static void mergeSort(int[] arr, int start, int mid, int end) {
        int[] sorted = new int[arr.length];
        int i=start;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j])
              sorted[k++] = arr[i++];
            else
              sorted[k++] = arr[j++];
          }
          if(i>mid) {
            while(j<=end) {
                sorted[k++] = arr[j++];
            }
        }else {
            while(i<=mid){
                sorted[k++] = arr[i++];
              }
        }
        for(int a=start; a<=end; a++) {
            result[a] = sorted[a];
        }
    }
    public static void merge(int start , int end, int[] arr) {
        if(start<end){
            int mid = (start + end )/2;
            merge(start , mid, arr);
            merge(mid+1, end, arr);
            mergeSort(arr, start, mid, end);
        }
    }
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int line = sc.nextInt();
        int[] arr =new int[line];
        for(int i=0; i<line; i++) {
            arr[i] =sc.nextInt();
        }
        result = new int[arr.length];
        merge(0, arr.length-1, arr);
        for(int i=0; i<result.length; i++)
            System.out.println(result[i]);
       }
    
}


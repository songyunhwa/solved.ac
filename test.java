import java.util.*;
import java.io.*;
class Solution {

    public static void main(String[] args) throws IOException{
        int answer =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String line = br.readLine();
        String[] arr = new String[Integer.parseInt(line)];

       for(int i=0; i<arr.length; i++) {
        String input = br.readLine();
        arr[i] = input;
       }
       Arrays.sort(arr, new Comparator<String>(){
           @Override
           public int compare(String a, String b){
              
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }else 
                return a.length() - b.length();
           }
       });
       for(int i=0; i<arr.length ; i++){
        if(i > 0){ 
            if(!arr[i-1].equals(arr[i]))
             System.out.println(arr[i]);
        }else System.out.println(arr[i]);
     }

    }
}

// 왜틀렸는지 모르겠음
import java.util.*;
import java.io.*;
class test {

    public static void main(String[] args) throws IOException{
        int answer =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String str = br.readLine();
        String[] strs = str.split(" ");

        int[][] arr = new int[Integer.parseInt(strs[1])][4];
        for(int i=0; i<Integer.parseInt(strs[0]); i++ ) {
            String input = br.readLine();
            for(int j=0; j<Integer.parseInt(strs[1]); j++) {
                if(input.substring(j, j+1).equals("A"))
                arr[j][0]++;
                if(input.substring(j, j+1).equals("T"))
                arr[j][1]++;
                if(input.substring(j, j+1).equals("G"))
                arr[j][2]++;
                if(input.substring(j, j+1).equals("C"))
                arr[j][3]++;
            }
        }
        int result =0;
        String result1 = "";
        for(int j=0; j<Integer.parseInt(strs[1]); j++) {
            int max = Math.max(arr[j][0], Math.max(arr[j][1], Math.max(arr[j][2], arr[j][3])));
            
            String cur = "";
            for(int t=0; t<4; t++){
                if(arr[j][t] == max && cur.equals("")) {
                    if(t==0){   
                        result1 += "A"; cur = "A"; continue;
                    }
                    if(t==3){   
                        result1 += "C"; cur = "C";continue;
                    }
                    if(t==2){   
                        result1 += "G"; cur = "G";continue;
                    }
                    if(t==1){   
                        result1 += "T"; cur = "T";continue;
                    }
                
                   
                }else {
                    result += arr[j][t];
                }
            }
        }
        System.out.println(result1);
        System.out.println(result);
    }
}

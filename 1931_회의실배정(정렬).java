import java.util.*;
import java.io.*;
class test {
    public static class bang implements Comparable<bang>{
        int start;
        int end;
        public bang(int s, int e){
            this.start= s;
            this.end = e;
        }
        @Override
        public int compareTo(bang h2){
            bang h1 = this;
            if(h1.start - h2.start > 0) {
                return 1;
            }else {
                if(h1.end - h2.end > 0) {
                    return 1;
                }else return -1;
            }

        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<bang> arr = new ArrayList<bang>();
        while(cnt > 0){
            cnt--;
            String[] str = br.readLine().split(" ");
            arr.add(new bang(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }

        Collections.sort(arr);
        bang now = arr.get(0);
        int result =1;
        for(int i=1; i<arr.size(); i++) {
            
            if(now.end  <= arr.get(i).start){
                result++;
                now = arr.get(i);
            }
        }
         System.out.println(result);
    }
}


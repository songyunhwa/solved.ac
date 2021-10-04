// 시간초과로 실패
import java.util.*;
import java.io.*;
class test {
    public static class Num {
        public int index;
        public int number;
 
        public Num(int index, int num){
            this.index = index;
            this.number = num;
        }
    }
    public static void main(String[] args) throws IOException{
        int answer =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);

        HashSet<Num> hash = new HashSet<Num>();
        for(int i=0; i<n ; i++) {
            String line = br.readLine();
            Num nn = new Num(i, Integer.parseInt(line));
            hash.add(nn);
        }
        int cnt = m+k;
        while(cnt>0) {
            cnt--;

            String[] strs1 = br.readLine().split(" ");
            Iterator<Num> it = hash.iterator();
            if(Integer.parseInt(strs1[0]) == 1){
                while (it.hasNext()){
                Num now = it.next();
                if(now.index == Integer.parseInt(strs1[1])-1){
                    //변경일 시에
                        now.number = Integer.parseInt(strs1[2]);
                    }
                }
            }else {
                int sum = 0;
                while (it.hasNext()){
                    Num now = it.next();
                    if(now.index >= Integer.parseInt(strs1[1])-1 &&
                    now.index <= Integer.parseInt(strs1[2])-1){
                        sum += now.number;
                    }      
                
                }
                System.out.println(sum);
            }
        }     
    }
}


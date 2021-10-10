import java.util.*;
import java.io.*;
class 올림픽 {
    public static class medal implements Comparable<medal> {
        int country;
        int a;
        int b;
        int c;
        int rank = 1;
        public medal(int cout, int x,int y,int z, int rank){
            this.country = cout;
            this.a = x;
            this.b = y;
            this.c = z;
            this.rank = rank;
        }
    
        @Override
        public int compareTo(medal m2) {
            medal m1 = this;
            int cmp = m1.a-m2.a;
            if(cmp > 0) return -1;
            else if(cmp < 0) return 1;
            else{
                int cmp1= m1.b-m2.b;
                if(cmp1 > 0) return -1;
                else if(cmp1 <0){
                   return 1;
                }else {
                    int cmp2 = m1.c-m2.c;
                    if(cmp2 >0 ) return -1;
                    else 
                    return 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        ArrayList<medal> arr = new ArrayList<medal>();
        for(int i=0; i<n; i++){
            medal m = new medal(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(), 1);
            arr.add(m);
        }
        Collections.sort(arr);
    
        for(int i=1; i<n; i++ ) {
            if(arr.get(i).a == arr.get(i-1).a &&
            arr.get(i).b == arr.get(i-1).b &&
            arr.get(i).c == arr.get(i-1).c) {
                arr.get(i).rank = arr.get(i-1).rank;
            }else {
                arr.get(i).rank = i+1;
            }
        }

        for(int i=0; i<n; i++){
            if(arr.get(i).country == k) {
                System.out.println(arr.get(i).rank);
                return;
            }
        }
    }
}

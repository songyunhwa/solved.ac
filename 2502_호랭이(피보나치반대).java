public class 2502_호랭이(피보나치반대) {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        int[] a = new int[n+1];
        int[] b = new int[n+1];
        a[1]=1;
        b[2]=1;
         for(int i=3; i<=n; i++){
            a[i] = a[i-1] + a[i-2];
            b[i] = b[i-1] + b[i-2];
        }
                //aA +  bB = K 
        int A=a[n];
        int B=b[n];
        for(int i=1; i<=1000000; i++){
            if((k- A * i) %B ==0) {
                System.out.println(i);
                System.out.println((k- A * i)/B);
                return;
            }
        }

    }

}

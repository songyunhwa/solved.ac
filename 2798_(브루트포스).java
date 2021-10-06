public abstract class 2798_(브루트포스) {
    import java.io.*;


    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr =new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int result =0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    if(arr[i] + arr[j] +arr[k] >result &&
                    arr[i] + arr[j] + arr[k] <=m) {
                        result = arr[i] + arr[j] + arr[k];
                    }
                }
            }
        }
       
       
        System.out.println(result);
    }


}

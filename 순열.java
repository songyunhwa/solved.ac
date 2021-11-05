public class 순열 {
    // 문제가 아니고 공부하는중...
    public static void swap (int[] arr , int start , int end) {
        int n = arr[start];
        arr[start] =arr[end];
        arr[end] = n;
    }
    public static void permutation (int[] arr , int now , int end, int target) {
        if(now == target){
            for(int i=0; i<end; i++){
                System.out.print(arr[i] + " ");
                
            }
            return;
        }
        if(now>target){
            return;
        }

        for(int i=now ; i<=end; i++){
        swap(arr, i , now);
        permutation(arr, now+1 , end, target);
        swap(arr, i , now);
        }

    }
}

// 처음에 for문으로 그냥 뒤에서부터 출렸했는데 왜인지 자꾸 틀림;;;

import java.util.*;
import java.io.*;
class test {
    // 10진법 -> b 진법으로
    public static void conversion(int a, int n) {
        Stack<Integer> stack = new Stack<Integer>();
        while(a != 0) {
            stack.push(a%n);
            a/= n;            
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }

    // a 진법 -> 10 진법으로
    public static int conversion2(int[] a, int n) {
        int result =0;

        for(int i=0; i<a.length; i++) {
            result = result * n + a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // a의 진법
        int b = sc.nextInt(); // b의 진법

        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i=0; i<m; i++ ){
            int k = sc.nextInt();
            arr[i] = k;
        }

        int k = conversion2(arr, a);
        conversion(k , b);
   
    }
}

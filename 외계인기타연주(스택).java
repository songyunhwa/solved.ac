public class 외계인기타연주(스택) {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]); // 줄
        int p = Integer.parseInt(strs[1]); // 프렛
        Stack<Integer>[] st = new Stack[7];        
        for (int i = 0; i <= 6; i++)
            st[i] = new Stack<>();

        int cnt=0;
        for(int i=0; i<n; i++){
            strs = br.readLine().split(" ");
            int n1 = Integer.parseInt(strs[0]); // 줄
            int p1 = Integer.parseInt(strs[1]); // 프렛
            
            while(!st[n1].isEmpty()){
                int p2 = st[n1].peek();
                    if(p2 > p1){ // 프렛이 크면
                        while(!st[n1].isEmpty()){
                            p2 = st[n1].peek();
                            if(p2 <= p1){
                                break;
                            }else {st[n1].pop(); cnt++;}
                        }
                        
                    }
                    if(p2 < p1){
                        st[n1].push(p1);
                        cnt++;
                        break;
                    }else { // 같으면
                        break;

                    }
                 
                
            }
            if(st[n1].isEmpty()){
                st[n1].push(p1);
                cnt++;
            }

        }
        
        System.out.println(cnt);
    }

}

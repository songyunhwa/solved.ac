public class 절댓값힙(pq) {
    public static void main(String[] args) throws IOException{


        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) return o1 > o2 ? 1 : -1; // - 가 앞으로
            return abs1 - abs2; // 더 큰 수가 앞으로
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n ; i++) {
            int now = Integer.parseInt(br.readLine());
            if(now == 0) {
                if(pq.isEmpty()){
                    System.out.println(0);
                
                }else{
                        int first = (int)pq.poll();
                        System.out.println(first);
                   }
            }else {
                pq.offer(now);
            }
        }
        
    }
}

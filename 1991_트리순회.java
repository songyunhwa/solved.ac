public class 1991_트리순회 {
    class Node {
        char cur;
        Node left;
        Node right;
        public Node(char a){
            this.cur = a;
        }
    }

    class Tree{
        Node root;
        public void add(char data, char left, char right){
            if(root == null){
                if(data!='.'){
                    root = new Node(data);
                }
                if(left!='.'){
                    root.left = new Node(left);
                }
                if(right!='.'){
                    root.right = new Node(right);
                }
            }else {
                search(root , data ,left ,right);
            }
        }
        public void search(Node root, char data ,char left, char right){
            if(root == null) return;

            if(root.cur == data){
                if(left!='.'){
                    root.left = new Node(left);
                }
                if(right!='.'){
                    root.right = new Node(right);
                }
            }else {
                search(root.left , data, left ,right);
                search(root.right, data ,left, right);
            }
        }
        public void preOrder(Node a){
            System.out.println(a.cur);
            if(a.left!=null) preOrder(a.left);
            if(a.right!=null)preOrder(a.right);
        }
        public void inOrder(Node a){
            if(a.left!=null) inOrder(a.left);
            System.out.println(a.cur);
            if(a.right!=null)inOrder(a.right);
        }
        public void postOrder(Node a){
            if(a.left!=null)postOrder(a.left);
            if(a.right!=null)postOrder(a.right);
            System.out.println(a.cur);
        }
    };


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree tree = new Tree();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] strs=  br.readLine().split(" ");
            char a= strs[0].charAt(0);
            char b= strs[1].charAt(0);
            char c= strs[2].charAt(0);
            tree.add(a,b,c);

        }
        tree.preOrder(tree.root);
        tree.inOrder(tree.root);
        tree.postOrder(tree.root);

       
    }
}

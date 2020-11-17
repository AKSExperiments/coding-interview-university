package interviews;

public class reconstructBinaryTree {

    public static void inOrderPreOrder(BTNode root, int[] inOrder, int[] postOrder, int inBegin, int inEnd, int postEnd) {
        if(inBegin > inEnd) {
            return;
        }

        if(inBegin == inEnd) {
            root = new BTNode(inOrder[inBegin]);
            System.out.print("Data");System.out.println(inOrder[inBegin]);
            return;
        }

        int rootPIndex = -1;
        int rootIIndex = -1;
        for(int i = inBegin; i <= inEnd; i++) {
            for( int j = postEnd; j >= 0; j--) {
                if(inOrder[i] == postOrder[j]) {
                    if(rootPIndex < j) {
                        rootPIndex = j;
                        rootIIndex = i;
                    }
                }
            }
        }
        if(rootIIndex == -1) {
            return;
        }
        root = new BTNode(postOrder[rootPIndex]);
        System.out.print("RI");System.out.println(rootIIndex);
        System.out.print("RP");System.out.println(rootPIndex);
        System.out.print("Data");System.out.println(postOrder[rootPIndex]);
        inOrderPreOrder(root.left, inOrder, postOrder, inBegin, rootIIndex-1, rootPIndex-1);
        inOrderPreOrder(root.right, inOrder, postOrder, rootIIndex+1, inEnd, rootPIndex-1);
    }

    public static void main(String[] args) {
        int[] inOrder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};
        BinaryTree bt = new BinaryTree();
        inOrderPreOrder(bt.root, inOrder, postOrder, 0, inOrder.length-1, postOrder.length-1);
    }
}

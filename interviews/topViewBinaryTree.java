package interviews;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class topViewBinaryTree {

    public static void recTree(BTNode root, HashMap<Integer,Integer> dirLevelHM, TreeMap<Integer,Integer> dirValueHM, int level, int direction) {
        if(root == null)
            return;
        if(dirLevelHM.containsKey(direction)) {
            if( dirLevelHM.get(direction) > level) {
                dirLevelHM.put(direction,level);
                dirValueHM.put(direction,root.val);
            }
        } else {
            dirLevelHM.put(direction,level);
            dirValueHM.put(direction,root.val);
        }
        recTree(root.left, dirLevelHM, dirValueHM, level + 1, direction - 1);
        recTree(root.right, dirLevelHM, dirValueHM,level + 1, direction + 1);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new BTNode(5);
        tree.root.left = new BTNode(4);
        tree.root.left.right = new BTNode(3);
        tree.root.left.right.right = new BTNode(10);
        tree.root.left.right.right.right = new BTNode(11);
        tree.root.left.right.right.right.right = new BTNode(12);
        tree.root.left.right.right.right.right.right = new BTNode(13);
        tree.root.left.right.right.right.right.right.right = new BTNode(14);
        tree.root.left.left = new BTNode(2);
        tree.root.left.left.right = new BTNode(1);
        tree.root.right = new BTNode(6);
        tree.root.right.left = new BTNode(7);
        tree.root.right.right = new BTNode(8);
         /*
                        5
                     /     \
                    4       6
                  /   \   /   \
                 2    3  7     8
               /   \
             null   1
        */
        HashMap<Integer, Integer> dirLevelHM = new HashMap<Integer, Integer>();
        TreeMap<Integer, Integer> dirValueHM = new TreeMap<Integer, Integer>();
        recTree(tree.root, dirLevelHM, dirValueHM, 0, 0);
        for (Map.Entry<Integer, Integer> entry : dirValueHM.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

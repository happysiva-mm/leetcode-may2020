/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
*/
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCousins{

    public static void main(String[] args){
        
        System.out.println("Tell if the nodes are cousins ...See the problem description");

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        System.out.println(isCousins(root, 4, 5));

    }
    static boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root.val == x || root.val == y){
            return false;
        }
        TreeNode parentx = null;
        TreeNode parenty = null;
        TreeNode parent = null;
        queue.add(root);
        int levelx = -1;
        int levely = -1;
        int currentLevel = 0;

        while(!queue.isEmpty()){


            int nodeAtEachLevel = queue.size();
            currentLevel++;
            while(nodeAtEachLevel>0){
               
                TreeNode popNode = queue.remove();
                nodeAtEachLevel--;
                parent = popNode;   
    
                if(popNode.left!=null){
                    if(popNode.left.val == x){
                       
                        parentx = parent;
                        levelx=currentLevel;
                    } 
                    if(popNode.left.val == y){
                        
                        parenty = parent;
                        levely = currentLevel;
                    } 
                    queue.add(popNode.left);          
                }
    
                if(popNode.right!=null){
                    if(popNode.right.val == x){
                       
                        parentx = parent;
                        levelx = currentLevel;
                    } 
                    if(popNode.right.val == y){
                      
                        parenty = parent;
                        levely = currentLevel;
                    }
                    queue.add(popNode.right);
                }

            }

            

            if(parentx!=null && parenty!=null && levelx == levely){
                if(parentx.val!=parenty.val){
                    return true;
                }
            }
        }

        if(parentx!=null && parenty!=null && levelx == levely){
            if(parentx.val!=parenty.val){
                return true;
            }
        }

        return false;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    LinkedList<TreeNode> array = new LinkedList<>();
    LinkedList<TreeNode> memory = new LinkedList<>();

    private TreeNode sweep(TreeNode root) {
        if (root.left != null) {
            TreeNode left = root.left;
            memory.push(root);
            root.left = null;
            return sweep(left);
        }
        return root;
    }

    private TreeNode climb(TreeNode node, int k) {
        TreeNode parent = memory.peek();
        if (node.right == null) {
            memory.pop();
            return parent;
        }
        TreeNode right  = node.right;
        node.right = null;
        return sweep(right);
    }

    private TreeNode traverse(TreeNode root, int k) {
        TreeNode smallest = sweep(root);
        if (smallest == root) {
            array.add(root);
            if (array.size() == k) {
                return root;
            }
            TreeNode parent = climb(root, k);
            return traverse(parent, k);
        }
        return traverse(smallest, k);
    }

    private int find(TreeNode root, int k) {
        TreeNode node = traverse(root, k);
        return node.val;
    }

    public int kthSmallest(TreeNode root, int k) {
        return find(root, k);
    }
}


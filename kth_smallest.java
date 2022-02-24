public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        inorder(root,list,k);
        return list.get(k-1);
    }
    private void inorder(TreeNode root, List<Integer> list, int k) {
        if(root == null || list.size()>k)
            return;
        inorder(root.left, list,k);
        list.add(root.val);
        inorder(root.right,list,k);
    }

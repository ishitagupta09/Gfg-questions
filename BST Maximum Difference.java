class Solution{
    public static int maxDifferenceBST(Node root,int target){
        Node targetNode=null;
        long sumtarget=0;
        while(root!=null){
            if(root.data==target){
                targetNode=root;
                break;
            }
            sumtarget+=root.data;
            if(root.data<target) root=root.right;
            else root=root.left;
        }
        if(targetNode==null) return -1;
        long lsum=sumChild(targetNode.left);
        long rsum=sumChild(targetNode.right);
        if(lsum==0) return (int)(sumtarget-rsum);
        if(rsum==0) return (int)(sumtarget-lsum);
        return (int)Math.max(sumtarget-lsum,sumtarget-rsum);
    }
    
    static long sumChild(Node root){
        if(root==null) return 0;
        long lsum=sumChild(root.left);
        long rsum=sumChild(root.right);
        if(root.left==null) return root.data+rsum;
        if(root.right==null) return root.data+lsum;
        return root.data+Math.min(lsum,rsum);
        
    }
}

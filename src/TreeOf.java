public class TreeOf {
    static Node append(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value > node.value) {
            node.right = append(node.right, value);
        } else if (value < node.value) {
            node.left = append(node.left, value);
        } else {
            return node;
        }
        return node;
    }
    static boolean containsNode(Node node, int value){
        if (node == null){return false;}
        if (value == node.value){return true;}
        if (value > node.value){
            return containsNode(node.right, value);
        } else {
            return containsNode(node.left, value);
        }
    }
    static int min(Node node){
        if (node.left == null){
            return node.value;
        } else {
            return min(node.left);
        }
    }
    static Node deleteOfNode(Node node, int value){
        if (node == null){return null;}
        if (value > node.value){
            node.right = deleteOfNode(node.right, value);
        } else if(value < node.value){
            node.left = deleteOfNode(node.left, value);
        } else {
            if (node.left == null && node.right==null){
                return null;
            } else if (node.right == null){
                return node.left;
            } else if (node.left == null){
                return node.right;
            } else {
                int minVal = min(node.right);
                node.value = minVal;
                node.right = deleteOfNode(node.right, minVal);
                return node;
            }
        }
        return node;
    }
    static class BinaryTree {
        Node root;
        public void add(int value) {
            root = append(root, value);
        }
        public boolean contains(int value){
            return containsNode(root, value);
        }
        public void delete(int value){
            root = deleteOfNode(root, value);
        }
    }
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.add(5);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        System.out.println(tree.contains(1));
        System.out.println(tree.contains(8));

        tree.delete(8);
        System.out.println(tree.contains(8));



    }
}
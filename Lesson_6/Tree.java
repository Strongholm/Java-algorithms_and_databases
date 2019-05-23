import java.util.NoSuchElementException;

public class Tree<T extends Comparable<T>, V> {

    private class Node{

        T key;
        V value;
        Node leftNode;
        Node rightNode;
        int size;
        int height;

        public Node(T key, V value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    private Node root = null;

    public boolean isBalanced(){

        return isBalanced(root);
    }

    private boolean isBalanced(Node node){

        if(node == null || node.height==0){
            return true;
        }

        int difference = height(node.leftNode) - height(node.rightNode);
        boolean result;
        if(difference == 0 || difference == -1 || difference == 1){
            result = true;
        } else {
            result = false;
        }

        return result && isBalanced(node.leftNode) && isBalanced(node.rightNode);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node == null){
            return 0;
        } else {
            return node.size;
        }
    }

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null){
            return 0;
        } else {
            return node.height;
        }
    }

    public V get(T key){
        return get(root, key);
    }

    private V get(Node node, T key){

        if(key == null) {
            throw new IllegalArgumentException("Исключение ");
        }

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp == 0){
            return node.value;
        }

        if (cmp < 0){
            return get(node.leftNode, key);
        } else {
            return get(node.rightNode, key);
        }
    }

    public boolean contrains(T key){
        return get(key) != null;
    }

    public void put(T key, V value){
        root = put(root, key, value);
    }

    private Node put(Node node, T key, V value){

        if(key == null) {
            throw new IllegalArgumentException();
        }

        if(node == null){
            return new Node(key, value, 1, 0);
        }

        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            node.value = value;
        } else if(cmp < 0){
            node.leftNode = put(node.leftNode,key,value);
        } else if(cmp > 0){
            node.rightNode = put(node.rightNode,key,value);
        }

        node.size = size(node.leftNode) + size(node.rightNode) + 1;
        node.height = height(node.leftNode) < height(node.rightNode) ? height(node.rightNode) : height(node.leftNode);
        ++node.height;
        return node;
    }

    public void remove(T key){
        root = remove(root, key);
    }

    private Node remove(Node node, T key){
        if(node == null){
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.leftNode = remove(node.leftNode, key);
        } else if(cmp > 0){
            node.rightNode = remove(node.rightNode, key);
        } else {
            if(node.leftNode == null){
                return node.rightNode;
            }
            if (node.rightNode == null){
                return node.leftNode;
            }

            Node tmp = node;
            node = max(node.leftNode);
            node.leftNode = removeMax(tmp.leftNode);
            node.rightNode = tmp.rightNode;
            tmp = null;
        }

        node.size = size(node.leftNode) + size(node.rightNode) + 1;
        node.height = height(node.leftNode) < height(node.rightNode) ? height(node.rightNode) : height(node.leftNode);
        ++node.height;
        return node;
    }

    private Node min (Node node){
        if(node.leftNode == null){
            return node;
        } else {
            return min(node.leftNode);
        }
    }

    private Node max (Node node){
        if(node.rightNode == null){
            return node;
        } else {
            return max(node.rightNode);
        }
    }

    public V min (){
        return min(root).value;
    }

    public V max (){
        return max(root).value;
    }

    private Node removeMin(Node node){
        if( node.leftNode == null){
            return  node.rightNode;
        } else {
            node.leftNode = removeMin(node.leftNode);
        }

        node.size = size(node.leftNode) + size(node.rightNode) + 1;
        node.height = height(node.leftNode) < height(node.rightNode) ? height(node.rightNode) : height(node.leftNode);
        ++node.height;
        return node;
    }

    private Node removeMax(Node node){
        if( node.rightNode == null){
            return  node.leftNode;
        } else {
            node.rightNode = removeMax(node.rightNode);
        }

        node.size = size(node.leftNode) + size(node.rightNode) + 1;
        node.height = height(node.leftNode) < height(node.rightNode) ? height(node.rightNode) : height(node.leftNode);
        ++node.height;
        return node;
    }

    public void removeMin(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        root = removeMin(root);
    }

    public void removeMax(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        root = removeMax(root);
    }
}
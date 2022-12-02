/**
 * Created by kristofer on 7/13/20.
 */
public class TreeOneZero {
    Node root;

    private Node addRecursive(Node current, Integer value){
        //if the current Node is null
        if(current == null){
            //we insert a new node in that position
            return new Node(value);
        }
        //if the new node's value is lower than the current node's,
        if(current.value > value){
           //we make our new value the left side of the next value
            current.left = addRecursive(current.left,value);
        } else if (current.value < value) {
            current.right = addRecursive(current.right, value);
        } else {
            //the value is already there dummy
            return current;
        }return current;
    }

    //the add method sets the root equal to addRecursive, which returns the current node
    public void add (Integer value){
        this.root = addRecursive(root , value);
    }
    private boolean containsNodeRecursive(Node current, Integer value){
        if (current == null){
            return false;
        }
        if(current.value.equals(value)){
            return true;
        }
//        if (current.value > value){
//            current.left = containsNodeRecursive(current.left, value);
//            return false;
//        } else if (current.value < value){
//            current.right = containsNodeRecursive(current.right, value);
//        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(Integer value){
        return containsNodeRecursive(root, value);
    }
    //in the method below, we are returning the node that we are removing wtf
    private Node deleteRecursive(Node current, Integer value){
        if(current == null){
            return null;
        }
        if (current.left == null){
            return current.right;
        } else if (current.right == null){
            return current.left;
        }
        int smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private int findSmallestNode(Node n){
        if (n.left == null){
            return n.value;
        } else {return findSmallestNode(n);}
    }
    public void delete (Integer value){
        root = deleteRecursive(root,value);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node){
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
}

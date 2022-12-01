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
        if (current.value > value){
            current.left = containsNodeRecursive(current.left, value);
            return false;
        } else if (current.value < value){
            current.right = containsNodeRecursive(current.right, value);
        }
    }
}

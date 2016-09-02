/*Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.

        1) You are given a binary tree of N nodes. While it is mostly alright, there is one extra edge that violates the tree property. Your job is to find it and eliminate it.

public class Node<T> {

    T data;
    Node left;
    Node right;

    Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree {

    public void eliminateError(Node root) {

        if(root == null) {
            return;
        }

        HashSet<Node> mySet= new HashSet<>();
        Queue<Node> queue= new LinkedList<>();
        boolean isError = false;
        primary.add(root);
        Node node;

        while(!queue.isEmpty() && !isError) {

            node = queue.remove();
            if(!mySet.contains(node) {
                mySet.add(node);
            }

            if(node.left != null) {
                if(mySet.contains(node.left)) {
                    isError = true;
                    node.left = null;
                } else {
                    queue.add(node.left);
                }
            }

            if(node.right != null && !isError) {
                if(mySet.contains(node.right)) {
                    isError = true;
                    node.right = null;
                } else {
                    queue.add(node.right);
                }
            }

        }

    }
}

2) List unit tests for this calculator function:
        string calc(string a, string op, string b)
        Ex: calc(“2”, “+”, “3”) returns “5”


        Basic case: calc(“2”, “+”, “3”) returns “5”
        float: calc(“2.2”, “+”, “3.5”) returns “5.7”
        negative integers: calc(“-2”, “+”, “3”) returns “1”
        negative float: calc(“-2.0”, “+”, “3.5”) returns “1.5”
        zero: calc(“0”, “+”, “0”) returns “0”
        invalid input: calc(“”, “+”, “”) throws InValidInputException
        invalid input: calc(“a”, “+”, “b”) throws InValidInputException
        invalid input: calc(“%”, “+”, “&”) throws InValidInputException
        huge numbers: calc(“huge number”, “+”, “huge number”) returns ans - huge number
        invalid operand: calc(“2”, “&”, “3”) throws InValidOperandException
        calc(“2”, “/”, “0”) returns “NaN”
        calc(“002”, “+”, “005”) returns “7”
        calc(“2.0.0”, “+”, “005”) returns “7”


*/
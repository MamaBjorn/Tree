
package Tree;
public class NodeTree {
    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            return current;
        }
        return current;
    }


    public Node DeleteRecursive(Node current, int value) {
        if (current == null) return null;

        if (value == current.data) {
            if (current.left == null && current.right == null) return null;
            if (current.right == null) return current.left;
            if (current.left == null) return current.right;
            int smallestValue = FindSmallestValue(current.right);
            current.data = smallestValue;
            current.right = DeleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.data) {
            current.left = DeleteRecursive(current.left, value);
            return current;
        }
        current.right = DeleteRecursive(current.right, value);
        return current;
    }

    private int FindSmallestValue(Node current) {
        return current.left == null? current.data : FindSmallestValue(current.left);
    }

    public void Remove(int value) {
        root = DeleteRecursive(root, value);
    }

    public void RecPrintTree(Node node) {
        if (node.left != null) RecPrintTree(node.left);
        System.out.println(node.data);
        if (node.right != null) RecPrintTree(node.right);
    }

    public void PrintTree() {
        Node node = root;
        RecPrintTree(node);
        System.out.println("____________");
    }

    public static void main(String[] args) {
        NodeTree n = new NodeTree();
        n.add(4);
        n.add(2);
        n.add(1);
        n.add(3);
        n.add(5);
        n.add(6);

        n.PrintTree();

        n.Remove(2);

        n.PrintTree();

    }
}

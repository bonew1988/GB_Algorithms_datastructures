package HW;

public class hw3 {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int key;
        Node left;
        Node right;
        Node parent;
        boolean color;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.color = RED;
        }
    }

    private Node root;

    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null)
            rightChild.left.parent = node;
        rightChild.parent = node.parent;
        if (node.parent == null)
            root = rightChild;
        else if (node == node.parent.left)
            node.parent.left = rightChild;
        else
            node.parent.right = rightChild;
        rightChild.left = node;
        node.parent = rightChild;
        return rightChild;
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null)
            leftChild.right.parent = node;
        leftChild.parent = node.parent;
        if (node.parent == null)
            root = leftChild;
        else if (node == node.parent.right)
            node.parent.right = leftChild;
        else
            node.parent.left = leftChild;
        leftChild.right = node;
        node.parent = leftChild;
        return leftChild;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void add(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            root.color = BLACK;
            return;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (key < current.key)
                current = current.left;
            else if (key > current.key)
                current = current.right;
            else
                return; // Узел с таким ключом уже существует, просто игнорируем добавление
        }

        newNode.parent = parent;
        if (key < parent.key)
            parent.left = newNode;
        else
            parent.right = newNode;

        fixRedBlackTree(newNode);
    }

    private void fixRedBlackTree(Node node) {
        while (isRed(node.parent)) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (isRed(uncle)) {
                    // Случай 1: Дядя узла является красным
                    flipColors(node.parent.parent);
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        // Случай 2: Дядя узла является черным, и узел является правым потомком своего родителя
                        node = node.parent;
                        rotateLeft(node);
                    }
                    // Случай 3: Дядя узла является черным, и узел является левым потомком своего родителя
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateRight(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (isRed(uncle)) {
                    // Случай 1: Дядя узла является красным
                    flipColors(node.parent.parent);
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        // Случай 2: Дядя узла является черным, и узел является левым потомком своего родителя
                        node = node.parent;
                        rotateRight(node);
                    }
                    // Случай 3: Дядя узла является черным, и узел является правым потомком своего родителя
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node == null)
            return;
        printTree(node.left);
        System.out.println(node.key + " " + (node.color == RED ? "RED" : "BLACK"));
        printTree(node.right);
    }

    public static void main(String[] args) {
        hw3 tree = new hw3();

        // Добавление элементов в дерево
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(9);
        tree.add(1);
        tree.add(7);
        tree.add(10);

        // Вывод дерева
        tree.printTree();
    }
}

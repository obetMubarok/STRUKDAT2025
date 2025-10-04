package BST;

class Node {

    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
    }
}

class MyBST {
    Node root;
    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (key > current.data) {
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    }
                    current = current.right;
                } else {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    }
                    current = current.left;
                }
            }
        }
    }

    public boolean find(int key) {
        boolean result = false;
        Node current = root;
        while (current != null) {
            if (key == current.data) {
                result = true;
                break;
            } else if (key > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    public Node getSuccesor(Node del) {
        Node current = del.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void delete(int key) {
        Node current = root;
        Node parent = root;
        boolean right = false;

        
        while (key != current.data) {
            parent = current;
            if (key > current.data) {
                right = true;
                current = current.right;
            } else {
                right = false;
                current = current.left;
            }
        }

        if (current.right == null && current.left == null) {
            if (current == root) {
                root = null;
            } else if (right) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        } 
        
        else if (current.right != null) {
            if (current == root) {
                root = current.right;
            } else if (right) {
                parent.right = current.right;
            } else {
                parent.left = current.right;
            }
        } 
        
        else if (current.left != null) {
            if (current == root) {
                root = current.left;
            } else if (right) {
                parent.right = current.left;
            } else {
                parent.left = current.left;
            }
        } 
        
        else {
            Node successor = getSuccesor(current);
            delete(successor.data);
            if (current == root) {
                root.data = successor.data;
            } else if (right) {
                parent.right.data = successor.data;
            } else {
                parent.left.data = successor.data;
            }
        }
    }
}

public class DemoBST {

    public static void main(String[] args) {
        MyBST my = new MyBST();
        my.insert(50);
        my.insert(40);
        my.insert(45);
        my.insert(80);
        my.insert(90);
        my.insert(95);
        my.insert(85);

        my.delete(80);
        my.inOrder(my.root);
    }
}

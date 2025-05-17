package BST;

class Node {

    int data;//
    Node right;//menunjuk ke node kanan
    Node left;//menunjuk ke node kiri\

    public Node(int data) {
        this.data = data;
    }

}

class MyBST {

    Node root;

    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {//jika BSt masih kosong
            root = newNode;
        } else {//jika tidak kosong
            Node current = root;
            while (true) {
                if (key > current.data) {//belok kanan
                    if (current.right == null) {
                        current.right = newNode;//tempel nodebaru
                        break;
                    }
                    current = current.right;
                } else {//belok kiri
                    if (current.left == null) {
                        current.left = newNode;//tempel node baru
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
        Node current = del.right;//kanan 1 kali
        while (current.left != null) {//ke kiri sampai ujung
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

        //menentukan node yang dihapus(current) dan nilai right
        while (key != current.data) {
            parent = current;//parent mengikuti current
            //current pindah ke kanan atau ke kiri
            if (key > current.data) {//belok kanan
                right = true;
                current = current.right;
            } else {//belok kiri
                right = false;
                current = current.left;
            }
        }

        //1. node daun / tidak punya anak
        if (current.right == null && current.left == null) {
            if (current == root) {
                root = null;
            } else if (right) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        } 
        
        //2.a punya anak kanan
        else if (current.right != null) {
            if (current == root) {
                root = current.right;
            } else if (right) {
                parent.right = current.right;
            } else {
                parent.left = current.right;
            }
        } 
        
        //2.b punya anak kiri
        else if (current.left != null) {
            if (current == root) {
                root = current.left;
            } else if (right) {
                parent.right = current.left;
            } else {
                parent.left = current.left;
            }
        } 
        
        //3. punya 2 anak
        else {
            Node successor = getSuccesor(current);//pengganti
            delete(successor.data);//hapus successor dari BST
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

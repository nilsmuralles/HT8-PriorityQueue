package src;

public class PriorityQueue<T extends Comparable<T>> {
    private Node<T> root;
    private int count;
    
    public PriorityQueue() {
        this.count = 0;
    }

    public void insert(T value) {
        count++;
        insert(root, value, 0);
    }

    private void insert(Node<T> current, T value, int displacement) {
        Node<T> newNode = new Node<T>(value);
        String path = Integer.toBinaryString(count);

        if (current == null) {
            root = newNode;
            return;
        }

        for (int i = 1 + displacement; i < path.length(); i++) {
            char c = path.charAt(i);

            if (c == '0') {
                if (current.getLeft() != null) {
                    displacement++;
                    insert(current.getLeft(), value, displacement);
                    break;
                } else {
                    newNode.setParent(current);
                    current.setLeft(newNode);
                    evalInvariantOrderInsertion(current.getLeft());
                    System.out.println(((Patient)current.getLeft().getValue()).getPrecedence());
                    break;
                }   
            }

            else if (c == '1') {
                if (current.getRight() != null) {
                    displacement++;
                    insert(current.getRight(), value, displacement);
                    break;
                } else {
                    newNode.setParent(current);
                    current.setRight(newNode);
                    evalInvariantOrderInsertion(current.getRight());
                    System.out.println(((Patient)current.getRight().getValue()).getPrecedence());
                    break;
                }
            }
        }    
    }

    private void evalInvariantOrderInsertion(Node<T> current) {
        if (current.getParent() == null) {
            return;
        } else {
            if (current.getValue().compareTo(current.getParent().getValue()) == 1) {
                swap(current, current.getParent());
                evalInvariantOrderInsertion(current.getParent());
            }
        }
    }

    private void swap(Node<T> n1, Node<T> n2) {
        T v1 = n1.getValue();
        T v2 = n2.getValue();
        n1.setValue(v2);
        n2.setValue(v1);
    }
}

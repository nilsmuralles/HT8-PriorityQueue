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

        //evaluateInherentOrder(current.getRight(), current.getLeft());

        for (int i = 1 + displacement; i < path.length(); i++) {
            char c = path.charAt(i);

            if (c == '0') {
                if (current.getLeft() != null) {
                    insert(current.getLeft(), value, displacement++);
                    break;
                } else {
                    newNode.setParent(current);
                    current.setLeft(newNode);
                    break;
                }   
            }

            else if (c == '1') {
                if (current.getRight() != null) {
                    insert(current.getRight(), value, displacement++);
                    break;
                } else {
                    newNode.setParent(current);
                    current.setRight(newNode);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unused")
    private void evaluateInherentOrder(Node<T> target, Node<T> reference) { 
        if (target != null && reference != null) {
            if (target.getValue().compareTo(reference.getValue()) == 1) {
                swap(target, reference);
                return;
            }
        } 
        return;
    }

    private void swap(Node<T> n1, Node<T> n2) {
        T value1 = n1.getValue();
        T value2 = n2.getValue();
        n1.setValue(value2);
        n2.setValue(value1);
    }
}

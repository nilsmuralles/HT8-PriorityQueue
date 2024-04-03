package src;

public class PriorityQueue<T extends Comparable<T>> {
    private Node<T> root;
    private int count;
    
    public PriorityQueue() {
        this.count = 0;
    }

    public void insert(T value) {
        count++;
        insert(root, value);
    }

    private void insert(Node<T> current, T value) {
        if (current == null) {
            root = new Node<T>(value);
            return;
        }

        if (current.getLeft() == null || current.getRight() == null) {
            if (current.getLeft() == null) {
                Node<T> left = new Node<T>(value);
                left.setParent(current);
                current.setLeft(left);
                evaluateInherentOrder(left);

            } else {
                Node<T> right = new Node<T>(value);
                right.setParent(current);
                current.setRight(right);
                evaluateInherentOrder(right);
            }

        } else {
            insert(current.getLeft(), value);
        }

    }

    private void evaluateInherentOrder(Node<T> current) {
        if (current.getValue().compareTo(current.getParent().getValue()) == 1) {
            swap(current.getParent(), current);
        }
    }

    private void swap(Node<T> target, Node<T> reference) {
        T targetValue = target.getValue();
        T referenceValue = reference.getValue();
        target.setValue(referenceValue);
        reference.setValue(targetValue);
    }
}

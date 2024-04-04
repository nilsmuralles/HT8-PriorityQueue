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

    public T pop() {
        if (count == 0) {
            return null;

        } else if (count == 1) {
            return root.getValue();

        } else if (count == 2) {
            if (root.getValue().compareTo(root.getLeft().getValue()) == -1) {
                swap(root, root.getLeft());
            }
        }

        T rootValue = root.getValue();
        Node<T> lastNode = getLastNode(root, 0);
        Node<T> lastNodeParent = lastNode.getParent();

        swap(root, lastNode);
        lastNode.setValue(null);

        if (lastNodeParent.getLeft() != null) {
            if ((lastNodeParent.getLeft().getValue() == null)) {
                lastNodeParent.setLeft(null);
            }
        }

        if (lastNodeParent.getRight() != null) {
            if ((lastNodeParent.getRight().getValue() == null)) {
                lastNodeParent.setRight(null);
            }
        }
        count--;

        evalInvariantOrderPop(root);
        return rootValue;
    }

    private Node<T> getLastNode(Node<T> current, int displacement) {
        String pathToLastNode = Integer.toBinaryString(count);

        if (current.getLeft() == null && current.getRight() == null) {;
            return current;
        }

        for (int i = 1 + displacement; i < pathToLastNode.length(); i++) {
            char c = pathToLastNode.charAt(i);
            
            if (c == '0') {
                displacement++;
                return getLastNode(current.getLeft(), displacement);
            }

            if (c == '1') {
                displacement++;
                return getLastNode(current.getRight(), displacement);
            }
        }
        
        return null;
    }

    private void evalInvariantOrderPop(Node<T> current) {
        if (current.getLeft() == null && current.getRight() == null) {
            return;
        }

        if (current.getRight() == null) {
            if (current.getValue().compareTo(current.getLeft().getValue()) == 1) {
                swap(current, current.getLeft());
                evalInvariantOrderPop(current.getLeft());
            }

        } else {
            if (current.getRight().getValue().compareTo(current.getLeft().getValue()) == 1) {
                swap(current.getLeft(), current.getRight());
            }
            swap(current, current.getLeft());
            evalInvariantOrderPop(current.getLeft());
        }
    }
}

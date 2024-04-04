package src;

/**
 * @author Nils Muralles
 * @since 03/04/24
 * @description ADT de una Priority Queue basada en un Min Heap
 */
public class PriorityQueue<T extends Comparable<T>> {
    private Node<T> root;
    private int count;
    
    /**
     * Constructor de la Priority Queue
     */
    public PriorityQueue() {
        this.count = 0;
    }

    /**
     * Método público con el que el usuario inserta un valor a la cola
     * @param value Valor a insertar
     */
    public void insert(T value) {
        count++;
        insert(root, value, 0);
    }

    /**
     * Método privado que trabaja la lógica para la inserción de manera recursiva
     * @param current Nodo actual
     * @param value Valor a insertar
     * @param displacement Medida de los bits avanzados en el número binario que representa el camino hacia el último nodo
     */
    private void insert(Node<T> current, T value, int displacement) {
        Node<T> newNode = new Node<T>(value);
        String path = Integer.toBinaryString(count);

        if (current == null) { // Caso base
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

    /**
     * Método privado con el que se evalúa el orden invariante cuando se inserta un valor
     * @param current Nodo actual
     */
    private void evalInvariantOrderInsertion(Node<T> current) {
        if (current.getParent() == null) { // Caso base: Nodo actual es la raíz
            return;
        } else {
            // Si el nuevo nodo tiene mayor prioridad se intercambia con su padre
            if (current.getValue().compareTo(current.getParent().getValue()) == 1) { 
                swap(current, current.getParent());
                evalInvariantOrderInsertion(current.getParent());
            }
        }
    }

    /**
     * Método privado que intercambia los valores de dos nodos
     * @param n1 Nodo uno 
     * @param n2 Nodo dos
     */
    private void swap(Node<T> n1, Node<T> n2) {
        T v1 = n1.getValue();
        T v2 = n2.getValue();
        n1.setValue(v2);
        n2.setValue(v1);
    }

    /**
     * Método público con el que el usuario obtiene el valor de mayor prioridad en la cola
     * @return Valor de mayor prioridad
     */
    public T pop() {
        if (count == 0) { 
            return null;

        } else if (count == 1) { 
            return root.getValue();

        } else if (count == 2) { // Si hay al menos dos elementos
            if (root.getValue().compareTo(root.getLeft().getValue()) == -1) {
                swap(root, root.getLeft());
            }
        }

        T rootValue = root.getValue();
        Node<T> lastNode = getLastNode(root, 0);
        Node<T> lastNodeParent = lastNode.getParent();

        swap(root, lastNode);

        // Se elimina el nodo como tal y no únicamente el valor del mismo
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

    /**
     * Método privado con el que se obtiene el último nodo
     * @param current Nodo actual
     * @param displacement Medida de los bits avanzados en el número binario que representa el camino hacia el último nodo
     * @return Último nodo
     */
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

    /**
     * Se evalúa el orden invariante a la hora de eliminar un valor
     * @param current Nodo actual
     */
    private void evalInvariantOrderPop(Node<T> current) {
        if (current.getLeft() == null && current.getRight() == null) { // Caso base: Nodo actual es una hoja
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

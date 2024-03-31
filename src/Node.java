package src;

/**
 * @author Nils Muralles
 * @since 30/03/24
 * @description Clase nodo para una Priority Queue
 */

public class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;
    Node<T> parent;

    /**
     * Constructor de la clase Nodo
     * @param value Valor asignado al nodo
     */
    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    /**
     * Devuelve el valor del nodo
     * @return Valor del nodo
     */
    public T getValue() {
        return value;
    }

    /**
     * Actualiza el valor del nodo
     * @param value valor del nodo
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Devuelve el nodo izquierdo
     * @return nodo izquierdo
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Actualiza el nodo izquierdo
     * @param left nodo izquierdo 
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * Devuelve el nodo derecho
     * @return nodo derecho
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * Actualiza el nodo derecho
     * @param right nodo derecho 
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * Devuelve el nodo padre
     * @return nodo padre
     */
    public Node<T> getParent() {
        return parent;
    }

    /**
     * Actualiza el nodo padre
     * @param left nodo padre 
     */
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

}
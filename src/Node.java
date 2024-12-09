public class Node<T extends Comparable<T>> {
    public T value;
    public Node<T> prev;
    public Node<T> nxt;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> prev, Node<T> nxt) {
        this.value = value;
        this.prev = prev;
        this.nxt = nxt;
    }

    @Override
    public String toString() {
        return (prev == null ? "" : prev.value + " <- ") + value + (nxt == null ? "" : " -> " + nxt.value);
    }
}

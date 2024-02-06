package one.digitalinnovation;



public class Node<T> {
    private T content;
    private Node<T> nextNode;

    public Node(T content) {
        this.nextNode = null;
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{content=" + content + '}';
    }
}

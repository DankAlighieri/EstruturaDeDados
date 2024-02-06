package one.digitalinnovation;

public class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int listSize;

    public CircularLinkedList() {
        this.tail = null;
        this.head = null;
        this.listSize = 0;
    }
    public T get(int index) {
        return this.getNode(index).getContent();
    }
    private Node<T> getNode(int index) {
        if (this.listSize == 0) throw new IndexOutOfBoundsException("List is empty");

        if(index == 0 ){
            return this.tail;
        }

        Node<T> auxNode = tail;
        for(int i = 0; (i < index) && (auxNode != null); i++) {
            auxNode = auxNode.getNextNode();
        }

        return auxNode;
    }

    public void add(T content) {
        Node<T> newNode = new Node<>(content);

        if(this.isEmpty()){
            this.head = newNode;
            this.tail = this.head;
            this.head.setNextNode(tail);
        } else {
            newNode.setNextNode(this.tail);
            this.head.setNextNode(newNode);
            this.tail = newNode;
        }
        this.listSize++;
    }

//    TODO
//    Add method that takes an index and add it into that index
    public void add(int index, T content) {
        Node<T> newNode = new Node<>(content);
        Node<T> auxNode = this.tail;

        if(this.isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            this.head.setNextNode(tail);
        }

        for (int i = 0; i < this.size(); i++) {
            auxNode = auxNode.getNextNode();
        }

        try {
            if(index == 0 ){
                newNode.setNextNode(this.tail);
                this.head.setNextNode(head);
                this.tail = newNode;
            } else if (auxNode == this.head) {
                this.head.setNextNode(newNode);
                newNode.setNextNode(this.tail);
                this.head = newNode;
            } else {
                newNode.setNextNode(auxNode);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        listSize++;
    }

    public void remove(int index) {
        if (index >= this.listSize) throw new IndexOutOfBoundsException("Index bigger than list");
        Node<T> auxNode = tail;

        if(index == 0){
            this.tail = this.tail.getNextNode();
            this.head.setNextNode(this.tail);
        }else {
            for(int i = 0; i < index - 1; i++){
                auxNode = auxNode.getNextNode();
            }
            auxNode.setNextNode(auxNode.getNextNode().getNextNode());
        }
        this.listSize--;
    }

    public boolean isEmpty() {
        return this.listSize == 0 ? true : false;
    }
    public int size() {
        return this.listSize;
    }

    @Override
    public String toString() {
        String returnStr = "";
        Node<T> auxNode = tail;

        for (int i = 0; i < this.size(); i++){
            returnStr +="[Node{content=" + auxNode.getContent() + "}{index = "+ i +"}]---> ";
            auxNode = auxNode.getNextNode();
        }

        returnStr += this.size() != 0 ? "(Retorna ao inicio)" : "[]";
        return returnStr;
    }
}

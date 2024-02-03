package one.digitalinnovation;

public class DoublyLinkedList<T> {

    private DoubleNode<T> firstNode;
    private DoubleNode<T> lastNode;
    private int listSize;

    public DoublyLinkedList(){
        this.firstNode = null;
        this.lastNode = null;
        this.listSize = 0;
    }

    public int size() {
        return this.listSize;
    }

    public T get(int index) {
        return this.getNode(index).getContent();
    }

    public void add(T element) {
        try {
            DoubleNode<T> newNode = new DoubleNode<>(element);

            //
            newNode.setNextNode(null);
            newNode.setPreviousNode(lastNode);
            // If the first node is null it means that this first node will be the new node
            if(firstNode == null) {
                firstNode = newNode;
            }
            // If the last node
            if(lastNode != null) {
                lastNode.setNextNode(newNode);
            }
            lastNode = newNode;
            listSize++;
        } catch (Exception NullPointerException) {
            throw new RuntimeException(NullPointerException);
        }
    }

    public void add(int index, T elemento) {
        try {
            DoubleNode<T> auxNode = getNode(index);
            DoubleNode<T> newNode = new DoubleNode<>(elemento);
            newNode.setNextNode(auxNode);

            if(newNode.getNextNode() != null) {
                newNode.setPreviousNode(auxNode.getPreviousNode());
                newNode.getNextNode().setPreviousNode(newNode);
                newNode.getPreviousNode().setNextNode(newNode);
            } else {
                newNode.setPreviousNode(lastNode);
                lastNode = newNode;
            }

            if(index == 0) {
                firstNode = newNode;
            } else {
                newNode.getPreviousNode().setNextNode(newNode);
            }
            listSize++;
        } catch (Exception NullPointerException) {
            throw new RuntimeException(NullPointerException);
        }
    }

    public void remove(int index) {
        try {
            // removendo o primeiro no
            if(index == 0) {
                // Setando o primeiro no para ser o segundo no da antiga lista
                firstNode = firstNode.getNextNode();
                // Verificando se ele o atual primeiro no é nulo ou não
                if(firstNode.getNextNode() != null){
                    // Setando o antigo primeiro no como nulo, que sera removido da memoria pela JVM
                    firstNode.setPreviousNode(null);
                }
            }
            // Caso nao seja o primeiro node
            else{
                // Node auxiliar sera o node no indice passado e sera removido
                DoubleNode<T> auxNode = getNode(index);
                // Pega o node anterior aquele a ser removido e atribui, ao seu proximo node, o node posterior aquele a ser removido.
                auxNode.getPreviousNode().setNextNode(auxNode.getNextNode());
                // Caso nao seja o ultimo no
                if (auxNode != lastNode) {
                    // pega o node posterior aquele a ser removido e atribui, ao seu proximo node, o node anterior aquele a ser removido.
                    auxNode.getNextNode().setPreviousNode(auxNode.getPreviousNode());
                } else lastNode = auxNode.getPreviousNode();
                System.out.println(auxNode);
            }
            System.out.println(lastNode);

            this.listSize--;
        } catch (Exception NullPointerException) {
            throw new RuntimeException(NullPointerException);
        }
    }

    private DoubleNode<T> getNode(int index) {
        DoubleNode<T> auxNode = firstNode;
//        If the index is greater than the size of the list, the verification auxNode!= null will return true and break the loop, dismissing other tests.
        for(int i = 0; (i < index) && (auxNode != null); i++){
            auxNode = auxNode.getNextNode();
        }
        return auxNode;
    }

    private boolean isEmpty() {
        return listSize == 0 ? true : false;
    }

    @Override
    public String toString() {
        String returnString = "";
        DoubleNode<T> auxNode = firstNode;
        for(int i = 0; i < size(); i++){
            returnString += "[No{conteudo=" + auxNode.getContent() +"}]--->";
            auxNode = auxNode.getNextNode();
        }
        returnString += "null";
        return returnString;
    }
}

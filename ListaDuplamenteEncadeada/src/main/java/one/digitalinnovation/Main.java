package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> myList = new DoublyLinkedList<>();

        myList.add("c1");
        myList.add("c2");
        myList.add("c3");
        myList.add("c4");
        myList.add("c5");
        myList.add("c6");
        myList.add("c7");

        System.out.println(myList);

        myList.remove(6);


        System.out.println(myList);
    }
}

package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList<String> myCircularLinkdedList = new CircularLinkedList<>();

//        myCircularLinkdedList.add("c0");
//        System.out.println(myCircularLinkdedList);
//        myCircularLinkdedList.remove(0);
//        System.out.println(myCircularLinkdedList);
//
//        myCircularLinkdedList.add("c1");
//        System.out.println(myCircularLinkdedList);
//        myCircularLinkdedList.add("c2");
//        myCircularLinkdedList.add("c3");
//        System.out.println(myCircularLinkdedList);

//        System.out.println(myCircularLinkdedList.get(0));
//        System.out.println(myCircularLinkdedList.get(1));
//        System.out.println(myCircularLinkdedList.get(2));
//        System.out.println(myCircularLinkdedList.get(3));

//        for(int i = 0; i < 20; i++){
//            System.out.println(myCircularLinkdedList.get(i));
//        }

        myCircularLinkdedList.add("c3");
        myCircularLinkdedList.add("c2");
        myCircularLinkdedList.add("c1");
        myCircularLinkdedList.add("c0");
        myCircularLinkdedList.add(3,"Novo No");


//        myCircularLinkdedList.remove(1);

        System.out.println(myCircularLinkdedList);
    }
}

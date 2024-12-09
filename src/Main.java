public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        list.addElement(3);
        list.addElement(6);
        list.addElement(8);
        list.addElement(7);
        list.addElement(1);
        list.addElement(4);
        System.out.println(list);
        list.sort();
        System.out.println(list);
    }
}
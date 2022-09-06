public class LinkedList {
    public Element head;

//    public LinkedList(Element _head) {
//        head = _head;
//    }

    public Element search(int key) {
        Element x = head;
        while (x != null && x.getKey() != key) {
            x = x.getNext();
        }
        return x;
    }

    public void insert(Element a) {
        a.setNext(head);
        if (head != null) {
            head.setPrev(a);
        }
        head = a;
        a.setPrev(null);
    }

    public void delete(Element a) {
        if (a.getPrev() != null) {
            a.getPrev().setNext(a.getNext());
        } else {
            head = a.getNext();
        }
        if (a.getNext() != null) {
            a.getNext().setPrev(a.getPrev());
        }
    }
}

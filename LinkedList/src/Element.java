public class Element {
    private Element prev;
    private Element next;
    private int key;

    public Element(int _key) {
        key = _key;
    }

    public int getKey() {
        return key;
    }

    public Element getPrev() {
        return prev;
    }

    public void setPrev(Element _prev) {
        prev = _prev;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element _next) {
        next = _next;
    }

    public void insert(Element _next){
        if (next == null) {
            next = _next;
        } else {
            next.insert(_next);
        }
    }
}

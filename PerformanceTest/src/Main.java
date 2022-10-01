public class Main {
    public static void main(String[] args) {
        System.out.println("Stack:");
        int num = 1000;
        for (int i = 1; i < 101; i++){
            System.out.println(testStack(i * num, 100000000));
        }

        System.out.println("Linked List:");
        num = 1000;
        for (int i = 1; i < 101; i++){
            System.out.println(testLinkedList(i * num, 100000000));
        }
    }

    public static int testStack(int startSize, int operations) {
        Stack s = new Stack(startSize+operations);
        for (int i = 0; i < startSize; i++) {
            s.push(i);
        }
        long start = System.currentTimeMillis() - 1663731000000L;
        for (long i = 0; i < operations; i++) {
            s.push((int)i);
            s.pop();
        }
        long end = System.currentTimeMillis() - 1663731000000L;

        return (int) (end - start);
    }

    public static int testLinkedList(int startSize, int operations) {
        LinkedList s = new LinkedList();
        for (int i = 0; i < startSize; i++) {
            s.insert(new Element(i));
        }
        long start = System.currentTimeMillis() - 1663731000000L;
        for (long i = 0; i < operations; i++) {
            s.insert(new Element((int)i));
            s.delete(s.head);
        }
        long end = System.currentTimeMillis() - 1663731000000L;

        return (int) (end - start);
    }
}

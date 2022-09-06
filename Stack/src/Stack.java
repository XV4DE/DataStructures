import java.util.ArrayList;
public class Stack {
    private int[] contents;
    private int top;


    public int getTop() {
        return top;
    }

    public Stack () {
        contents = new int[0];
        top = 0;
    }

    public Stack (int len) {
        contents = new int[len];
        top = 0;
    }

    public boolean empty() {
        return getTop() == 0;
    }

    public void push (int val) {
        try{
            contents[top++] = val;
        } catch (IndexOutOfBoundsException e) {
            throw(new RuntimeException("Stack overflow!"));
        }
    }

    public int pop () {
        try {
            return contents[--top];
        } catch (IndexOutOfBoundsException e) {
            throw(new RuntimeException("Stack underflow!"));
        }
    }
}
import java.util.logging.Logger;
import java.util.logging.Level;

class Main {
    private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    static int pass = 0;
    static int fail = 0;

    public static void main(String[] args) {
        testConstructStack();
        testPush();
        testPop();
        testPushPushPopPushPushPop();
        testPopWhenEmpty();
        testPushWhenFull();
        System.out.println("Passed " + pass + " Failed " + fail);

    }

    static void testConstructStack() {
        Stack dishes = new Stack(5);
        if (dishes.empty()) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed stack construction, expected empty stack got not empty");
        }
    }

    static void testPushPushPopPushPushPop() {
        Stack dishes = new Stack(5);
        dishes.push(1);
        dishes.push(2);
        int actual = dishes.pop();
        int expected = 2;
        if (actual == expected) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed multi push pop test, expected " + expected + " got " + actual);
        }
        dishes.push(3);
        dishes.push(4);
        actual = dishes.pop();
        expected = 4;
        if (actual == expected) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed multi push pop test, expected " + expected + " got " + actual);
        }
    }

    static void testPush() {
        Stack dishes = new Stack(5);
        dishes.push(31);
        if (!dishes.empty()) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed stack push, expected not empty got empty");
        }

        if (dishes.pop() == 31) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed stack push, expected 31 got not 31");
        }


    }

    static void testPop() {
        Stack ms = new Stack(5);
        ms.push(3);
        if (ms.pop() == 3) {
            pass++;
        } else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed stack pop, expected 3 got not 3");
        }
        ms.push(4);
        if (ms.pop() == 4) {
            pass++;
        } else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed stack pop, expected 4 got not 4");
        }
    }

    static void testPopWhenEmpty() {
        Stack dishes = new Stack();
        try {
            dishes.pop();
        } catch (RuntimeException e) {
            if (e.getMessage().equals("Stack underflow!")) {
                pass++;
                return;
            }
        }
        System.out.println("testUnderflow failed");
        fail++;
    }

    static void testPushWhenFull() {
        Stack ms = new Stack();
        try {
            ms.push(3);
        } catch (RuntimeException e) {
            if (e.getMessage().equals("Stack overflow!")) {
                pass++;
                return;
            }
        }
        System.out.println("testOverflow failed");
        fail++;
    }


}
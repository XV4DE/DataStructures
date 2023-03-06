import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

public class Main {
    public static int tests = 0;
    public static int passes = 0;
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method[] methods = new Method[] {
                gt("testEqualsSame"),

        };
        for (Method method: methods) {
            runTest(method);
        }

        System.out.println("Passed " + passes + "/" + tests + " tests.");
    }

    public static void runTest (Method m) throws InvocationTargetException, IllegalAccessException {
        tests++;
        Boolean b = (Boolean) m.invoke(null);
        if (!b) System.out.println("Failed " + m.getName());
        else passes++;
    }

    public static Method gt (String testName) throws NoSuchMethodException {
        return Tests.class.getDeclaredMethod(testName);
    }
}

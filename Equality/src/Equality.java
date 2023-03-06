import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class Equality {
    
    public static boolean equals (Object t0, Object t1) {
        if (t0.equals(t1)) {
            return true;
        }
        if (equals(t0.getClass(),(t1.getClass()))) {
            Class<?> tclass = t0.getClass();
            boolean allMatch = true;
            for (Method m: t0.getClass().getMethods()) {
                TypeVariable<Method>[] tvs = m.getTypeParameters();
                for (TypeVariable<Method> tv: tvs) {
                   
                }
            }
            if (allMatch) {
                return true;
            }
        }

        return false;
    }
//    Things are equal when...
//      - They are the same thing
//      - Each part matches one equal part of the other
//      - The two things are both equal to a third thing
//      - One can be losslessly transformed into something equal to the other
}

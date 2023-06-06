import java.util.Objects;

public class Node {
    public final Measurement measurement;
    public final long time;
    public Node parent;
    public Node lChild;
    public Node rChild;

    public Node (Measurement _measurement) {
        measurement = _measurement;
        time = measurement.time.time;
    }


    public void usurp (Node monarch) {
        if (monarch.parent != null) {
            monarch.parent.rChild = this;
            parent = monarch.parent;
        }
        monarch.parent = this;
        lChild = monarch;
    }

    public void subserve (Node monarch) {
        monarch.rChild = this;
        parent = monarch;
    }

    public void insert (Node n, int num) {
        if (isAPowerOfTwo(num)) {
            n.usurp(this);
            return;
        }
        if (rChild == null) {
            n.subserve(this);
            return;
        }
        rChild.insert(n, num - hyperfloor(num)/2);
    }

    public Node getLeftmost() {
        if (lChild == null) return this;
        return lChild.getLeftmost();
    }

    public Node getNextLargest() {
        if (rChild != null) {
            return rChild.getLeftmost();
        }
        if (parent != null && parent.lChild == this) return parent;
        return null;
    }

    public static boolean isAPowerOfTwo(int x) {
        double xLog2 = log2(x);
        return (int) xLog2 - xLog2 < 0.00001;
    }

    public static int hyperfloor(int x) {
        return exp2((int) log2(x));
    }

    public static double log2(int x) {
        return Math.log(x)/Math.log(2);
    }

    public static int exp2(int x) {
        int acc = 1;
        for (int i = 0; i < x; i++) acc *= 2;
        return acc;
    }

    public Measurement get(Timestamp t) {
        if (measurement.time.equals(t)) return measurement;
        if (measurement.time.time > t.time) {
            if (rChild != null) {return rChild.get(t);}
            else return null;
        }
        else return lChild.get(t);
    }

    public String toString() {
        return measurement.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return time == node.time && measurement.equals(node.measurement) &&
                Objects.equals(parent, node.parent) && Objects.equals(lChild, node.lChild) &&
                Objects.equals(rChild, node.rChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurement, time, parent, lChild, rChild);
    }
}

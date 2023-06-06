import java.sql.Time;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TimeTree {
    private Node root;
    private static int count = 1;

    public TimeTree(Node _root) {
        root = _root;
    }

    public void insert(Measurement newMeasurement) {
        insert(new Node(newMeasurement));
    }

    public void insert(Node newNode) {
        count++;
        root.insert(newNode, count);
        if (root.parent != null) {
            root = root.parent;
        }
    }

    public Measurement get(Timestamp t) {
        return root.get(t);
    }

    public Node getRoot () {return root;}

    public Measurement[] getContents() {
        int c = 0;
        Measurement[] out = new Measurement[count];
        Node focus = root.getLeftmost();

        while (true) {
            out[c++] = focus.measurement;
            if (focus.getNextLargest() == null) return out;
            focus = focus.getNextLargest();
        }
    }

    public String toString() {
        String out = "";
        ArrayList<Node> currentRow = new ArrayList<>();
        currentRow.add(root);
        ArrayList<Node> nextRow = new ArrayList<>();
        while (!currentRow.isEmpty()) {
            for (Node node : currentRow) {
                out += node.time + " ";
            }
            out += "\n";
            for (Node node : currentRow) {
                if (node.lChild != null) nextRow.add(node.lChild);
                if (node.rChild != null) nextRow.add(node.rChild);
            }
            currentRow = new ArrayList<>(nextRow);
            nextRow = new ArrayList<>();
        }
        return out;
    }
}

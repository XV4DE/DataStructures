public class BasicLogicalSentence implements LogicalSentence{
    private String pc;

    public BasicLogicalSentence (String a) {
        pc = a;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean unsatisfiable() {
        return false;
    }

    public boolean evaluate (TruthAssignment ta) {
        return ta.get(pc);
    }
}

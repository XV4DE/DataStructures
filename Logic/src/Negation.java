public class Negation implements LogicalSentence {
    private LogicalSentence arg;
    public Negation (LogicalSentence a) {
        arg = a;
    }

    @Override
    public boolean unsatisfiable() {
        return arg.isValid();
    }

    @Override
    public boolean isValid() {
        return arg.unsatisfiable();
    }

    @Override
    public boolean evaluate(TruthAssignment ta) {
        return !arg.evaluate(ta);
    }
}

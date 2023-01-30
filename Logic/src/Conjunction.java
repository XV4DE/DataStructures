public class Conjunction implements LogicalSentence{
    private LogicalSentence a1, a2;
    public Conjunction (LogicalSentence a1, LogicalSentence a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public boolean isValid() {
        return a1.isValid() && a2.isValid();
    }

    @Override
    public boolean unsatisfiable() {
        return a1.unsatisfiable() || a2.unsatisfiable();
    }
}

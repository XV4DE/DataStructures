public interface LogicalSentence {
    public boolean isValid();
    // public boolean evaluate(TruthAssignment t);
    boolean unsatisfiable();

    boolean evaluate(TruthAssignment ta);



}

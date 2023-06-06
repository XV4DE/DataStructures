import java.util.Objects;

public class Measurement {
    public final Unit unit;
    public final Timestamp time;
    public final double value;

    public Measurement(double _value, Unit _unit) {
        unit = _unit;
        value = _value;
        time = new Timestamp();
    }

    private Measurement(double _value, Unit _unit, Timestamp _time) {
        unit = _unit;
        value = _value;
        time = _time;
    }

    public static Measurement testConstructor(double _value, Unit _unit, Timestamp _time) {
        return new Measurement(_value, _unit, _time);
    }

    public static Measurement testConstructor(double _value, Unit _unit, long _time) {
        return new Measurement(_value, _unit, Timestamp.testConstructor(_time));
    }

    @Override
    public String toString() {
        return ""+value+" "+unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Measurement)) return false;
        Measurement that = (Measurement) o;
        return Double.compare(that.value, value) == 0 && unit.equals(that.unit) && time.equals(that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, time, value);
    }
}

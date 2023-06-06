import java.util.Objects;

public class Unit {
    public final String name;

    public Unit(String _name) {
        name = _name;
    }

    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit)) return false;
        Unit unit = (Unit) o;
        return Objects.equals(name, unit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

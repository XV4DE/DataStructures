import java.sql.Time;
import java.util.Objects;

public class Timestamp {
    public final long time;

    public Timestamp() {
        time = System.currentTimeMillis();
    }

    public static Timestamp testConstructor(long time) {
        return new Timestamp(time);
    }

    public Timestamp(long _time) {
        time = _time;
    }

    // damn, solid code, IntelliJ
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timestamp timestamp = (Timestamp) o;
        return time == timestamp.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }
}

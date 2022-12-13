public class Matter {
    boolean IAmFine = true;
    double myPosition = 0;
    double myVelocity = 0;
    double myAcceleration = 1;
    double force = 1;
    double mass = 2;

    public void updatePosition() {
        myPosition += myVelocity;
    }

    public void updateVelocity() {
        myVelocity += myAcceleration;
    }

    public void updateAcceleration() {
        myAcceleration += force/mass;
    }

    public void updateEmotionalStatus() {
        if (myPosition > 10) {
            IAmFine = false;
        } else {
            IAmFine = true;
        }
    }

    @Override
    public String toString() {
        if (IAmFine) {
            return "I'm fiiiiine! My position is: " + myPosition;
        }

        return "I am not fine :(";
    }
}

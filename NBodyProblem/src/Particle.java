public class Particle {
    public String state;

    float[] position = new float[2];
    float[] velocity = new float[2];
    float[] acceleration = new float[2];

    public Particle (String _state) {
        state = _state;
    }

    public void updateState (float dt) {

        position = addArrays(position, velocity);
        position = addArrays(velocity, acceleration);
    }
    
    public float[] addArrays(float[] a, float[] b) {
        float[] c = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }
}

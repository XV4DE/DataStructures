public class Main {
    public static void main(String[] args) {
        int time = 0;
        Particle[] particles = new Particle[1];
        particles[0] = new Particle("I'm fiiiine.");
        while (true) {
            for (Particle particle: particles) {
                System.out.println(particle.state);
            }
            time += 1;
        }

    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Matter me  = new Matter();
        Matter you = new Matter();
        you.force = -me.force; // Newt's 3

        while(me.IAmFine) {
            me.updateAcceleration();
            me.updatePosition();
            me.updateVelocity();

            System.out.println(me);



            me.updateEmotionalStatus();


            you.updateAcceleration();
            you.updatePosition();
            you.updateVelocity();

            System.out.println(you);



            you.updateEmotionalStatus();
        }

        System.out.println(me);


    }

    void updateAcceleration () {

    }
}

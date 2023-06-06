public class Main {
    public static void main(String[] args) {
        InfinitePlane p = new InfinitePlane();
        p.expandPlane();
        p.expandPlane();
        p.setPoint(1, 1, 1);
        p.setPoint(-1, 1, 2);
        p.setPoint(1, -1, 4);
        p.setPoint(-1, -1, 3);
        p.setPoint(-3, -3, 3);
        System.out.println(p);


        for (int i = 0; i < 100; i ++) {
            System.out.println(Snake.whereToPlace(i));
        }
    }
}

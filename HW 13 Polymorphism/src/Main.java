public class Main {

    public static void main (String[] args) {
        Polyhedron b = new Polyhedron(4) {
            @Override
            public double getSurfaceArea() {
                return 1;
            }

            @Override
            public double getVolume() {
                return 1;
            }
        };

        System.out.println(b);

//        Polyhedron[] a = new Polyhedron[3];
//        a[0] = new Tetrahedron(2);
//        a[1] = new Tetrahedron(5.0);
//        a[2] = new Icosahedron(10.0);
//        //System.out.println("is a == c?" + a.equals(c));
//        //System.out.println("is a == b?" + a.equals(b));
//
//        for (int i =0; i < a.length; i++) {
//            System.out.println(a[i].getVolume());
//            System.out.println(a[i]);
//        }

    }

}

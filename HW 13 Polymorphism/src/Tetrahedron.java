/**
 * AddController
 *
 * Serves the controller portion of the MVC paradigm, controls the overall function of the AddTweet view.
 *
 * @author Dylan Martin
 *
 * @version April 8, 2019
 *
 */

public class Tetrahedron extends Polyhedron {

    public Tetrahedron(double sideLength) throws IllegalArgumentException {
        super(sideLength);

        if (sideLength < 0.0) {
            throw new IllegalArgumentException("sideLength is negative!!");
        }
    }

    public double getSurfaceArea() {
        double sum;
        sum = Math.sqrt(3.0) * Math.pow(getSideLength(), 2);
        return sum;
    }

    public double getVolume() {
        double sum;
        sum = Math.pow(getSideLength(), 3) / (6.0 * Math.sqrt(2.0));
        return sum;
    }

    public boolean equals(Object object) {
        boolean equals = false;

        if (object instanceof Tetrahedron) {
            if (((Tetrahedron) object).getSideLength() == this.getSideLength()) {
                equals = true;
            }
        }
        return equals;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[" + String.format("%f", getSideLength())  + "]";
    }
}

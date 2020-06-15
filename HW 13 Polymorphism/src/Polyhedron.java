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

public abstract class Polyhedron {
    private double sideLength;

    public Polyhedron(double sideLength) throws IllegalArgumentException {
        this.sideLength = sideLength;

        if (sideLength < 0.0) {
            throw new IllegalArgumentException("sideLength is negative!!");
        }
    }

    public double getSideLength() {
        return this.sideLength;
    }

    public void setSideLength(double sideLength) throws IllegalArgumentException {
        if (sideLength < 0.0) {
            throw new IllegalArgumentException("sideLength is negative!!");
        } else {
            this.sideLength = sideLength;
        }
    }

    public boolean equals(Object object) {
        boolean equals = false;

        if (object instanceof Polyhedron) {
            if (((Polyhedron) object).getSideLength() == this.getSideLength()) {
                equals = true;
            }
        }
        return equals;
    }

    public String toString() {
        return "Polyhedron[" + String.format("%f", getSideLength())  + "]";
    }

    public abstract double getSurfaceArea();

    public abstract double getVolume();

}

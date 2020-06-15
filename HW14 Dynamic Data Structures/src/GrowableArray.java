/**
 * AddController
 *
 * Serves the controller portion of the MVC paradigm, controls the overall function of the AddTweet view.
 *
 * @author Dylan Martin
 *
 * @version April 8, 2019
 *
 * @param <T></> something
 */

public class GrowableArray<T> extends Object {
    private Object[] values = new Object[10];
    private int size = 0;

    public GrowableArray() {

    }

    public void add(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) { //corner cases
            throw new IndexOutOfBoundsException();

        }  else if (values[index] != null) { //insert and push array right
            if (size == values.length) { //double array size
                Object[] newValues = new Object[values.length * 2];
                for (int i = 0; i < values.length; i++) {
                    newValues[i] = values[i];
                }
                this.values = newValues;
                //System.out.println("DEBUG: doubling size before shifting = " + size());
            }

            Object[] newValues = new Object[values.length];
            for (int i = index; i < values.length - 1; i++) { //push array right
                newValues[i + 1] = values[i];
            }
            for (int i = 0; i < index; i++) {
                newValues[i] = values[i];
            }
            newValues[index] = value;
            this.values = newValues;
            size++;
            //System.out.println("Debug: insert and push size = " + size());

        } else if (size == values.length) { //double array size
            Object[] newValues = new Object[values.length * 2];
            for (int i = 0; i < values.length; i++) {
                newValues[i] = values[i];
            }
            newValues[index] = value;
            this.values = newValues;
            size++;
            //System.out.println("DEBUG: you are in the if statement that doubles size = "
             //       + size() + " length = " + values.length);

        } else if (index < values.length) { //normal replace null with value
            values[index] = value;
            size++;
            //System.out.println("Debug: regular add size = " + size());
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return (T) this.values[index];
        }
    }

    public T set(int index, T value) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.values[index] = value;
            return (T) values[index];
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
            } else if (values[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else {
            Object oldValue = values[index];
            values[index] = null;
            size--;
            return (T) oldValue;
        }
    }

    public void clear() {
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        if (size() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean equals(Object object) {
        boolean isEqual = true;
        if (object == null) {
            return false;
        } else if (object instanceof GrowableArray) {
            isEqual = false;
        }
        //TO DO:
        for (int i = 0; i < values.length; i++) {
            if (object.equals(values[i])) {
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    public String toString() {
        String valuesStr = "";
        for (int i = 0; i < size(); i++) {
            if (values[i] == null) {
                valuesStr += ", null";
            } else if (i == 0) {
                valuesStr += values[i].toString();
            } else {
                valuesStr += ", " + values[i].toString();
            }

        }
        //return valuesStr + " length: " + values.length + " size = " + size();
        return "{" + valuesStr + "}";
    }
}

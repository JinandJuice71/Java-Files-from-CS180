import java.text.DecimalFormat;
import java.util.Comparator;

import static java.lang.Double.parseDouble;
import static java.lang.Double.valueOf;

/**
 * An organism's genetic makeup.
 *
 * <p>Purdue -- CS18000 -- Spring 2019 -- Class and Methods -- Homework</p>
 *
 * @author Logan Kulinski, lbk@purdue.edu
 * @version February 16, 2019
 */

public class ComplexNumber implements Comparable<ComplexNumber> {

    //fields
    private double re; //The imaginary part of this complex number.
    private double im; //The real part of this complex number.

    //constructors
    public ComplexNumber() {
        re = 0.0;
        im = 0.0;
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumber(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        } else {
            this.re = complexNumber.getRe();
            this.im = complexNumber.getIm();
        }
    }

    //methods

    public synchronized double getRe() {
        return this.re;
    }

    public synchronized double getIm() {
        return this.im;
    }

    public synchronized void setRe(double re) {
        this.re = re;
    }

    public synchronized void setIm(double im) {
        this.im = im;
    }

    public synchronized ComplexNumber conjugate() {
        //double conjugate = 0.0;
        ComplexNumber conjugate = new ComplexNumber();
        conjugate.re = getRe();
        conjugate.im = getIm() * (-1);
        //ComplexNumber obj = new ComplexNumber(conjugate);
        return conjugate;
    }

    public synchronized ComplexNumber reciprocal() {
        ComplexNumber reciprocal = new ComplexNumber();
        reciprocal.re = re / (re * re + im * im);
        reciprocal.im = -1 * im / (re * re + im * im);
        //double reciprocalResult = valueOf(reciprocal.re - reciprocal.im);
        return reciprocal;
    }

    public synchronized ComplexNumber add(ComplexNumber complexNumber) throws IllegalArgumentException {
        ComplexNumber add = new ComplexNumber();
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        } else {
            add.re = getRe() + complexNumber.re;
            add.im = getIm() + complexNumber.im;
            return add;
        }

//        Returns the sum of this complex number and the specified complex number.
    }

    public synchronized ComplexNumber subtract(ComplexNumber complexNumber) throws IllegalArgumentException {
        ComplexNumber subtract = new ComplexNumber();

        if (complexNumber == null) {
            throw new IllegalArgumentException();
        } else {
            subtract.re = getRe() - complexNumber.re;
            subtract.im = getIm() - complexNumber.im;
            return subtract;
        }
    }

    public synchronized ComplexNumber multiply(ComplexNumber complexNumber) throws IllegalArgumentException {
        ComplexNumber multiply = new ComplexNumber();

        if (complexNumber == null) {
            throw new IllegalArgumentException();
        } else {
            multiply.re = (getRe() * complexNumber.re) - (getIm() * complexNumber.im);
            multiply.im = (getIm() * complexNumber.re) + (getRe() * complexNumber.im);
            return multiply;
        }
    }

    public synchronized ComplexNumber divide(ComplexNumber complexNumber) throws IllegalArgumentException {
        ComplexNumber divide = new ComplexNumber();

        if (complexNumber == null) {
            throw new IllegalArgumentException();
        } else {
            divide.re = (getRe() * complexNumber.re + getIm() * complexNumber.im)
                    / (complexNumber.re * complexNumber.re + complexNumber.im * complexNumber.im);
            divide.im = (getIm() * complexNumber.re - getRe() * complexNumber.im)
                    / (complexNumber.re * complexNumber.re + complexNumber.im * complexNumber.im);
            return divide;
        }
    }

    public synchronized int compareTo(ComplexNumber complexNumber) {
        int result = 0;
        if (complexNumber == null) {
            result = -1;
        } else {
            double reCompare = getRe() - complexNumber.re;
            double imCompare = getIm() - complexNumber.im;

            if (reCompare > 0) {
                result = 1;
            } else if (reCompare < 0) {
                result = -1;
            } else if (reCompare == 0) {
                if (imCompare > 0) {
                    result = 1;
                } else if (imCompare < 0) {
                    result = -1;
                } else if (imCompare == 0) {
                    result = 0;
                }
            }
        }
        return result;
    }







//        if (reCompare > 0) {
//            result = 1;
//        } else if (reCompare < 0) {
//            result = -1;
//        } else if (reCompare == 0) {
//            if(complexNumber == null) {
//                result = -1;
//            } else if (imCompare > 0) {
//                result = 1;
//            } else if (imCompare < 0) {
//                result = -1;
//            } else if (imCompare == 0) {
//                result = 0;
//            }
//        }
//
//        if (valueOf(getRe()) == null) {
//            result = 1;
//        } else if (valueOf(complexNumber.re) == null) {
//            result = -1;
//        } else if (reCompare > 0) {
//            result = 1;
//        } else if (reCompare < 0) {
//            result = -1;
//        } else if (reCompare == 0) {
//            if (valueOf(complexNumber.re) == null) {
//                result = 1;
//            } else if (valueOf(complexNumber.im) == null) {
//                result = -1;
//            } else if (imCompare > 0) {
//                result = 1;
//            } else if (imCompare < 0) {
//                result = -1;
//            } else if (imCompare == 0) {
//                result = 0;
//            }
//        }

        //THIS IS THE LATEST ONE
//        if (valueOf(getRe()) == null) {
//            result = 1;
//        } else if (valueOf(complexNumber.re) == null) {
//            result = -1;
//        } else if (reCompare > 0) {
//            result = 1;
//        } else if (reCompare < 0) {
//            result = -1;
//        } else if (reCompare == 0) {
//            if (complexNumber == null) {
//                result = 1;
//            } else if (complexNumber == null) {
//                result = -1;
//            } else if (imCompare > 0) {
//                result = 1;
//            } else if (imCompare < 0) {
//                result = -1;
//            } else if (imCompare == 0) {
//                result = 0;
//            }
//        }

    public synchronized boolean equals(Object object) {
        boolean identical = false;
        if (object instanceof ComplexNumber) {
            ComplexNumber object1 = (ComplexNumber)object;

            if (object1.re == getRe() && object1.im == getIm()) {
                identical = true;
            }
        }
        return identical;
    }

    @Override
    public synchronized String toString() {
        DecimalFormat df = new DecimalFormat("0.000000");
        String sign = " + ";
        double doubleRe = parseDouble(String.valueOf(this.re));
        double doubleIm = parseDouble(String.valueOf(this.im));

        if (doubleIm < 0) {
//            negative = true;
            doubleIm = Math.abs(doubleIm);
            sign = " - ";
        }

        return df.format(doubleRe) + sign + df.format(doubleIm) + "i";
    }

}

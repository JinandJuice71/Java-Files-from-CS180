public class Tester {
    public static void main(String[] args) {

//        ComplexNumber operandOne = new ComplexNumber(5.0, 5.0);
//        ComplexNumber operandTwo = new ComplexNumber(operandOne);
//        ComplexNumber operandThree = new ComplexNumber(5.0, 7.5);

        ComplexNumber operandOne = new ComplexNumber(5.0, 6.0);
        //ComplexNumber operandOne = null;
        ComplexNumber operandTwo = new ComplexNumber(operandOne);
       //ComplexNumber operandThree = new ComplexNumber(5.0, 5.0);
        ComplexNumber operandThree = null;


        //System.out.println(operandOne.add(operandTwo)); //displays 10.000000 + 10.000000i
//        System.out.println(operandOne.equals(operandTwo)); //displays true
        System.out.println(operandOne.compareTo(operandThree)); //displays -1

                //System.out.println(operandOne.multiply(operandThree));
    }
}
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter entry: ");
        String str = scanner.nextLine();

        int spaceCount = 0;
        String str1 = "";
        String str2 = "";
        String str3 = "";
        int str2Int = -1;
        int str3Int = -1;

//            if (str.equalsIgnoreCase("ADD")) {
//                returnMessage = "str1 == ADD!!";
//            }

        for(int i = 0; i < str.length(); i++){
            if(Character.isWhitespace(str.charAt(i))){
                //spaceIndex1 = i;
                spaceCount++;
                str1 = str.substring(0, i);
                for (int j = i + 1; j < str.length(); j++) {
                    if (Character.isWhitespace(str.charAt(j))) {
                        //spaceIndex2 = j;
                        spaceCount++;
                        str2 = str.substring(i+1, j);
                        str3 = str.substring(j+1, str.length());

                        try {
                            str2Int = Integer.parseInt(str2);
                            System.out.println("str2Int: " + str2Int);
                        } catch (NumberFormatException e) {
                            System.out.println("the first operand must be a valid integer\n");
                            break;
                        }

                        try {
                            str3Int = Integer.parseInt(str3);
                            System.out.println("st32Int: " + str3Int);
                        } catch (NumberFormatException e) {
                            System.out.println("the second operand must be a valid integer\n");
                            break;
                        }

                    }
                }
                break;
            }
            //System.out.println("requests must include an operation name, and two operands all separated by spaces\n");
            //return ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE;
        }
        //if (spaceIndex == 0) {
            //returnMessage = "requests must include an operation name, and two operands all separated by spaces\n";
            //System.out.println("requests must include an operation name, and two operands all separated by spaces\n");
        //} else
//        if (str1.equalsIgnoreCase("ADD") && str2.equals("2")) {
//            //returnMessage = "str1 == ADD!!";
//            System.out.println("str1 == ADD, str2 == 2");
//        }
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);

        if (spaceCount != 2) {
            System.out.println("requests must include an operation name, and two operands all separated by spaces\n");
            //returnMessage = "requests must include an operation name, and two operands all separated by spaces\n";
        } else if (str1.equalsIgnoreCase("ADD")) {
            int answer = str2Int + str3Int;
            String answerStr = Integer.toString(answer);
            System.out.println("answerStr = " + answerStr);
//            returnMessage = answerStr;
        } else if (str1.equalsIgnoreCase("SUBTRACT")) {
            int answer = str2Int - str3Int;
            String answerStr = Integer.toString(answer);
//            returnMessage = answerStr;
            System.out.println("answerStr = " + answerStr);
        }

    }
}

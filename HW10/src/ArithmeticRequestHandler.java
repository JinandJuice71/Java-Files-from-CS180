import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * A request handler for a server that performs simple arithmetic operations.
 *
 * <p>Purdue University -- CS18000 -- Spring 2019 -- External Communication -- Homework</p>
 *
 * @author Mark Jin
 * @version 03/28/2019
 */
public final class ArithmeticRequestHandler implements Runnable {
    /**
     * The client socket of this request handler.
     */
    private Socket clientSocket;

    /*
     * Error message constants.
     */

    private static final String ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE;

    private static final String ILLEGAL_OPERATION_NAME_ERROR_MESSAGE;

    private static final String ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE;

    private static final String ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE;

    static {
        ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE = String.format(
                "%s: requests must include an operation name, and two operands all separated by spaces",
                ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_OPERATION_NAME_ERROR_MESSAGE = String.format("%s: the operation name must be part of the protocol",
                ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE = String.format("%s: the first operand must be a valid integer",
                ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE = String.format("%s: the second operand must be a valid integer",
                ArithmeticProtocol.ILLEGAL_REQUEST);
    } //static

    /**
     * Constructs a newly allocated {@code ArithmeticRequestHandler} object with the specified client socket.
     *
     * @param clientSocket the client socket of this request handler
     * @throws IllegalArgumentException if the {@code clientSocket} argument is {@code null}
     */
    public ArithmeticRequestHandler(Socket clientSocket) throws IllegalArgumentException {
        if (clientSocket == null) {
            throw new IllegalArgumentException("clientSocket argument is null");
        } else {
            this.clientSocket = clientSocket;
        } //end if
    } //ArithmeticRequestHandler

    /**
     * Communicates with the client, and processes their requests until they disconnect.
     */
    @Override
    public void run() {
        try {
            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String str = br.readLine();
            System.out.println("Message received from client is " + str);

            String returnMessage = "-1";
            int spaceCount = 0;
            String str1 = "";
            String str2;
            String str3;
            int str2Int = -1;
            int str3Int = -1;
            boolean canRun = true;


            OutputStream os = clientSocket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            do {
                //System.out.println(str);
                //System.out.println(spaceCount);
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isWhitespace(str.charAt(i))) {
                        spaceCount++;
                        str1 = str.substring(0, i);
                        for (int j = i + 1; j < str.length(); j++) {
                            if (Character.isWhitespace(str.charAt(j))) {
                                spaceCount++;
                                str2 = str.substring(i + 1, j);
                                str3 = str.substring(j + 1, str.length());

                                try {
                                    str2Int = Integer.parseInt(str2);
                                } catch (NumberFormatException e) {
                                    returnMessage = ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE;
                                    canRun = false;
                                    break;
                                }

                                try {
                                    str3Int = Integer.parseInt(str3);
                                } catch (NumberFormatException e) {
                                    returnMessage = ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE;
                                    canRun = false;
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }

                if (canRun == true) {
                    if (spaceCount != 2) {
                        returnMessage = ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE;
                    } else if (str1.equalsIgnoreCase("ADD")) {
                        int answer = str2Int + str3Int;
                        String answerStr = Integer.toString(answer);
                        returnMessage = answerStr;
                    } else if (str1.equalsIgnoreCase("SUBTRACT")) {
                        int answer = str2Int - str3Int;
                        String answerStr = Integer.toString(answer);
                        returnMessage = answerStr;
                    } else if (str1.equalsIgnoreCase("MULTIPLY")) {
                        int answer = str2Int * str3Int;
                        String answerStr = Integer.toString(answer);
                        returnMessage = answerStr;
                    } else if (str1.equalsIgnoreCase("DIVIDE")) {
                        if (str3Int == 0) {
                            returnMessage = ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE;
                        } else {
                            int answer = str2Int / str3Int;
                            String answerStr = Integer.toString(answer);
                            returnMessage = answerStr;
                        }
                    } else {
                        returnMessage = ILLEGAL_OPERATION_NAME_ERROR_MESSAGE;
                    }
                } else if (canRun == false) {
                    canRun = true;
                }
                bw.write(returnMessage);
                bw.newLine();
                bw.flush();

                spaceCount = 0;
                str = br.readLine();

            } while (str != null);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try
            {
                clientSocket.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    } //run
}
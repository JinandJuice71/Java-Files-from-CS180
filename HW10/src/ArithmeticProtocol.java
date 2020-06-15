/**
 * A protocol for a server that performs simple arithmetic operations.
 *
 * <p>Purdue University -- CS18000 -- Spring 2019 -- External Communication -- Homework</p>
 *
 * @author Mark Jin
 * @version 03/28/2019
 */
public enum ArithmeticProtocol {
    /**
     * The singleton instance representing the addition operation.
     */
    ADD,

    /**
     * The singleton instance representing the subtraction operation.
     */
    SUBTRACT,

    /**
     * The singleton instance representing the multiplication operation.
     */
    MULTIPLY,

    /**
     * The singleton instance representing the division operation.
     */
    DIVIDE,

    /**
     * The singleton instance representing an illegal request.
     */
    ILLEGAL_REQUEST
}
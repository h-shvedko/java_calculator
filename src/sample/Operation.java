package sample;

/**
 * Created by hshvedko on 14-Dec-16.
 */
public class Operation {

    /**
     * Instance of Calculator class
     */
    private Calculator calculator;
    /**
     * Instance of InputNumber class
     */
    private InputNumber inputNumber;
    /**
     * Alias for action of clicking sum button
     */
    private static final String OPERATION_PLUS = "plus";
    /**
     * Alias for action of clicking equal button
     */
    private static final String OPERATION_EQUAL = "equal";
    /**
     * Alias for action of clicking minus button
     */
    private static final String OPERATION_MINUS = "minus";
    /**
     * Alias for action of clicking multiply button
     */
    private static final String OPERATION_MULTIPLY = "multiply";
    /**
     * Alias for action of clicking divide button
     */
    private static final String OPERATION_DIVIDE = "division";
    /**
     * Alias for action of clicking change sign button
     */
    private static final String OPERATION_CHANGE_SIGN = "changeSign";
    /**
     * Alias for action of clicking sqrt button
     */
    private static final String OPERATION_SQRT = "sqrt";
    /**
     * Alias for action of clicking backspace button
     */
    private static final String OPERATION_BACKSPACE = "backspace";
    /**
     * Alias for action of clicking one dividing to value button
     */
    private static final String OPERATION_ONE_DIVIDE = "oneDivide";
    /**
     * Alias for action of clicking doubleNull button
     */
    private static final String OPERATION_DOUBLE_NULL = "doubleNull";
    /**
     * Alias for action of clicking clear button
     */
    private static final String OPERATION_CLEAR = "clear";
    /**
     * Alias for action of clicking point button
     */
    private static final String OPERATION_POINT = "point";
    /**
     * Count of decimal values in number
     */
    private int decimalDigitCount;
    /**
     * Count of decimal values in number
     */
    private int decimalDigitSecondCount;
    /**
     * Variable which shows if we input number (true) or input operation (false)
     */
    private boolean ifInput = false;

    /**
     * Constructor of Operation class
     */
    public Operation() {
        this.calculator = new Calculator();
        this.inputNumber = new InputNumber(this.calculator);
    }

    /**
     * Method which execute action depends on given alias of action
     *
     * @param id - alias of action
     * @return - double number result of calculation
     */
    public double calculate(String id) {
        switch (id) {
            case OPERATION_PLUS:
                calculator.plus();
                this.setIfInput(false);
                break;
            case OPERATION_MINUS:
                calculator.minus();
                this.setIfInput(false);
                break;
            case OPERATION_DIVIDE:
                calculator.divide();
                this.setIfInput(false);
                break;
            case OPERATION_MULTIPLY:
                calculator.multiply();
                this.setIfInput(false);
                break;
            case OPERATION_POINT:
                inputNumber.point();
                this.setIfInput(true);
                break;
            case OPERATION_EQUAL:
                calculator.equal();
                this.setIfInput(false);
                break;
            case OPERATION_CLEAR:
                calculator.clear();
                this.setIfInput(false);
                break;
            case OPERATION_CHANGE_SIGN:
                calculator.changeSign();
                this.setIfInput(true);
                break;
            case OPERATION_ONE_DIVIDE:
                calculator.oneDivide();
                this.setIfInput(false);
                break;
            case OPERATION_SQRT:
                calculator.sqrt();
                this.setIfInput(false);
                break;
            case OPERATION_DOUBLE_NULL:
                inputNumber.input(0);
                inputNumber.input(0);
                this.setIfInput(true);
                break;
            case OPERATION_BACKSPACE:
                inputNumber.backspace();
                this.setIfInput(true);
                break;
            default:
                inputNumber.input(Integer.parseInt(id));
                this.setIfInput(true);
                break;
        }

        double number = inputNumber.getScreenValue();

        return number;
    }

    /**
     * Getter for decimalDigitCount variable
     *
     * @return decimalDigitCount - value which should be set to decimalDigitCount variable
     */
    public int getDecimalDigitCount() {
        this.decimalDigitCount = this.inputNumber.getDecimalDigitCount();
        return decimalDigitCount;
    }

    /**
     * Getter for decimalDigitSecondCount variable
     *
     * @return decimalDigitSecondCount - value which should be set to decimalDigitSecondCount variable
     */
    public int getDecimalSecondDigitCount() {
        this.decimalDigitSecondCount = this.inputNumber.getDecimalDigitSecondCount();
        return decimalDigitSecondCount;
    }

    /**
     * Getter for variable ifInput
     * @return
     */
    public boolean isIfInput() {
        return ifInput;
    }

    /**
     * Setter for variable ifInput
     * @param ifInput
     */
    public void setIfInput(boolean ifInput) {
        this.ifInput = ifInput;
    }
}

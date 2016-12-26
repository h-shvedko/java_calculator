package sample;

/**
 * Created by hshvedko on 14-Dec-16.
 */
public class Calculator {
    /**
     * Value to which we should apply our operation
     */
    private double memoryValue;
    /**
     * Operation value
     */
    private int operation;
    /**
     * Alias for empty operation
     */
    private static final int OPERATION_NONE = -1;
    /**
     * Alias for sum operation
     */
    private static final int OPERATION_PLUS = 0;
    /**
     * Alias for minus operation
     */
    private static final int OPERATION_MINUS = 1;
    /**
     * Alias for multiply operation
     */
    private static final int OPERATION_MULTIPLY = 2;
    /**
     * Alias for divide operation
     */
    private static final int OPERATION_DIVISION = 3;
    /**
     * Flag which shows if we have to move our screen number tot memory
     */
    private boolean moveScreenValueToMemory;
    /**
     * Instance of InputNumber class
     */
    private InputNumber input;

    /**
     * Cnstructor of Calculator class
     */
    public Calculator() {
        this.operation = OPERATION_NONE;
    }

    /**
     * Method of summarizing values
     */
    public void plus() {
        this.executePreviousOperation();
        this.operation = OPERATION_PLUS;
        this.setMoveScreenValueToMemory(true);
    }

    /**
     * Method of subtraction values
     */
    public void minus() {
        this.executePreviousOperation();
        this.operation = OPERATION_MINUS;
        this.setMoveScreenValueToMemory(true);
    }

    /**
     * Method of multiplying of values
     */
    public void multiply() {
        this.executePreviousOperation();
        this.operation = OPERATION_MULTIPLY;
        this.setMoveScreenValueToMemory(true);
    }

    /**
     * Method of dividing of values
     */
    public void divide() {
        this.executePreviousOperation();
        this.operation = OPERATION_DIVISION;
        this.setMoveScreenValueToMemory(true);
    }

    /**
     * Method which calculate values after clicking button =
     */
    public void equal() {
        this.executePreviousOperation();
        this.operation = OPERATION_NONE;
        this.setMoveScreenValueToMemory(true);
    }

    /**
     * Method which calculate values after clicking button "C"
     */
    public void clear() {
        this.operation = OPERATION_NONE;
        this.memoryValue = 0;
        this.input.setIsDecimal(false);
        this.input.setDecimalDigitCount(0);
        this.input.setScreenValue(0.0);
    }

    /**
     * Method which change sign og displayed value
     */
    public void changeSign(){
        double value = this.input.getScreenValue();
        this.input.setScreenValue((-1) * value);
    }

    /**
     * Method which calculate value of 1/value
     */
    public void oneDivide(){
        if(this.input.getDecimalDigitCount() == 0) {
            this.input.setDecimalDigitCount(2);
        }
        double value = this.input.getScreenValue();
        this.input.setScreenValue(1 / value);
    }

    /**
     * Method which calculate sqrt value
     */
    public void sqrt(){
        double value = this.input.getScreenValue();
        this.input.setScreenValue(Math.sqrt(value));
    }

    /**
     * Method which defines if there is any operation in memory and execute it
     */
    public void executePreviousOperation() {

        switch(this.operation){
            case OPERATION_PLUS:
                this.memoryValue += input.getScreenValue();
                input.setScreenValue(this.memoryValue);
                break;
            case OPERATION_MINUS:
                this.memoryValue -= input.getScreenValue();
                input.setScreenValue(this.memoryValue);
                break;
            case OPERATION_MULTIPLY:
                this.memoryValue *= input.getScreenValue();
                input.setScreenValue(this.memoryValue);
                break;
            case OPERATION_DIVISION:
                this.memoryValue /= input.getScreenValue();
                input.setScreenValue(this.memoryValue);
                break;
        }
    }

    /**
     * Setter for memoryValue variable
     */
    public void setMemoryValue() {
        this.setMoveScreenValueToMemory(false);
        this.memoryValue = input.getScreenValue();
        input.setScreenValue(0.0);
        input.setIsDecimal(false);
        input.setDecimalDigitCount(0);
    }

    /**
     * Getter for moveScreenValueToMemory variable
     * @return - value moveScreenValueToMemory
     */
    public boolean isMoveScreenValueToMemory() {
        return moveScreenValueToMemory;
    }

    /**
     * Setter for moveScreenValueToMemory variable
     * @param moveScreenValueToMemory
     */
    public void setMoveScreenValueToMemory(boolean moveScreenValueToMemory) {
        this.moveScreenValueToMemory = moveScreenValueToMemory;
    }

    /**
     * Setter for input variable
     * @param input - instance of InputNumber class
     */
    public void setInput(InputNumber input) {
        this.input = input;
    }
}

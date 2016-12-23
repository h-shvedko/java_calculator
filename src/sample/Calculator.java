package sample;

/**
 * Created by hshvedko on 14-Dec-16.
 */
public class Calculator {
    private double memoryValue;
    private int operation;
    private static final int OPERATION_NONE = -1;
    private static final int OPERATION_PLUS = 0;
    private static final int OPERATION_MINUS = 1;
    private static final int OPERATION_MULTIPLY = 2;
    private static final int OPERATION_DIVISION = 3;
    private boolean moveScreenValueToMemory;
    private InputNumber input;

    public Calculator() {
        this.operation = OPERATION_NONE;
    }

    public void plus() {
        this.executePreviousOperation();
        this.operation = OPERATION_PLUS;
        this.setMoveScreenValueToMemory(true);
    }

    public void minus() {
        this.executePreviousOperation();
        this.operation = OPERATION_MINUS;
        this.setMoveScreenValueToMemory(true);
    }

    public void muliply() {
        this.executePreviousOperation();
        this.operation = OPERATION_MULTIPLY;
        this.setMoveScreenValueToMemory(true);
    }

    public void divide() {
        this.executePreviousOperation();
        this.operation = OPERATION_DIVISION;
        this.setMoveScreenValueToMemory(true);
    }

    public void equal() {
        this.executePreviousOperation();
        this.operation = OPERATION_NONE;
        this.setMoveScreenValueToMemory(true);
    }

    public void clear() {
        this.operation = OPERATION_NONE;
        this.memoryValue = 0;
        this.input.setIsDecimal(false);
        this.input.setDecimalDigitCount(0);
        this.input.setScreenValue(0.0);
    }

    public void changeSign(){
        double value = this.input.getScreenValue();
        this.input.setScreenValue((-1) * value);
    }

    public void oneDivide(){
        double value = this.input.getScreenValue();
        this.input.setScreenValue(1 / value);
    }

    public void sqrt(){
        double value = this.input.getScreenValue();
        this.input.setScreenValue(Math.sqrt(value));
    }

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

    public void setMemoryValue() {
        this.setMoveScreenValueToMemory(false);
        this.memoryValue = input.getScreenValue();
        input.setScreenValue(0.0);
        input.setIsDecimal(false);
        input.setDecimalDigitCount(0);
    }

    public boolean isMoveScreenValueToMemory() {
        return moveScreenValueToMemory;
    }

    public void setMoveScreenValueToMemory(boolean moveScreenValueToMemory) {
        this.moveScreenValueToMemory = moveScreenValueToMemory;
    }

    public void setInput(InputNumber input) {
        this.input = input;
    }
}

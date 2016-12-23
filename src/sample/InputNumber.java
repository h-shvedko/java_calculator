package sample;

/**
 * Created by hshvedko on 14-Dec-16.
 */
public class InputNumber {

    private boolean isDecimal;

    private double screenValue;
    private int decimalDigitCount;
    private Calculator calculator;

    public InputNumber(Calculator calculator){
        this.calculator = calculator;
        this.calculator.setInput(this);
    }

    public void input(int val) {
        if (calculator.isMoveScreenValueToMemory()) {
            calculator.setMemoryValue();
        }

        if (!this.isDecimal) {
            this.screenValue = this.screenValue * 10 + val;
        } else {
            ++this.decimalDigitCount;
            this.screenValue += Math.pow(0.1, this.decimalDigitCount) * val;
        }
    }

    public boolean getIsDecimal(){ return this.isDecimal;}

    public void setIsDecimal(boolean data){ this.isDecimal = data; }

    public double getScreenValue() {
        return screenValue;
    }

    public void point() {
        this.isDecimal = true;
    }

    public void setDecimalDigitCount(int decimalDigitCount) {
        this.decimalDigitCount = decimalDigitCount;
    }

    public void setScreenValue(double screenValue) {
        this.screenValue = screenValue;
    }
}

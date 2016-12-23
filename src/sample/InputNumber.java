package sample;

/**
 * Created by hshvedko on 14-Dec-16.
 */
public class InputNumber {
    /**
     * Boolean value if clicked on decimal button
     */
    private boolean isDecimal;
    /**
     * Value which should be shown on display
     */
    private double screenValue;
    /**
     * Count of decimal values in number
     */
    private int decimalDigitCount;
    /**
     * Instance of Calculator class
     */
    private Calculator calculator;

    /**
     * Constructor of class InputNumber
      * @param calculator - instance of Ca;culator class
     */
    public InputNumber(Calculator calculator){
        this.calculator = calculator;
        this.calculator.setInput(this);
    }

    /**
     * Method which read value of clicked button and set it to screenValue
     * @param val - value which should be set to screenValue
     */
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

    /**
     * Getter method of isDecimal variable
     * @return - value of isDecimal variable
     */
    public boolean getIsDecimal(){ return this.isDecimal;}

    /**
     * Setter for isDecimal variable
     * @param data - value which should be set to isDecimal variable
     */
    public void setIsDecimal(boolean data){ this.isDecimal = data; }

    /**
     * Getter method of screenValue variable
     * @return - value of screenValue variable
     */
    public double getScreenValue() {
        return screenValue;
    }

    /**
     * Method which shows that there was clicked point button
     */
    public void point() {
        this.isDecimal = true;
    }

    /**
     * Setter for decimalDigitCount variable
     * @param decimalDigitCount - value which should be set to decimalDigitCount variable
     */
    public void setDecimalDigitCount(int decimalDigitCount) {
        this.decimalDigitCount = decimalDigitCount;
    }

    /**
     * Setter for screenValue variable
     * @param screenValue - value which should be set to screenValue variable
     */
    public void setScreenValue(double screenValue) {
        this.screenValue = screenValue;
    }
}

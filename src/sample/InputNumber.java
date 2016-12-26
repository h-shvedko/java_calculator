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
     *
     * @param calculator - instance of Ca;culator class
     */
    public InputNumber(Calculator calculator) {
        this.calculator = calculator;
        this.calculator.setInput(this);
    }

    /**
     * Method which read value of clicked button and set it to screenValue
     *
     * @param val - value which should be set to screenValue
     */
    public void input(int val) {
        if (calculator.isMoveScreenValueToMemory()) {
            calculator.setMemoryValue();
        }

        double signOfNumber = this.getSignOfScreenValue();
        if (!this.isDecimal) {
            this.screenValue = signOfNumber * (Math.abs(this.screenValue) * 10 + val);
        } else {
            ++this.decimalDigitCount;
            this.screenValue = signOfNumber * (Math.abs(this.screenValue) + (Math.pow(0.1, this.decimalDigitCount) * val));
        }
    }

    /**
     * Getter method of isDecimal variable
     *
     * @return - value of isDecimal variable
     */
    public boolean getIsDecimal() {
        return this.isDecimal;
    }

    /**
     * Setter for isDecimal variable
     *
     * @param data - value which should be set to isDecimal variable
     */
    public void setIsDecimal(boolean data) {
        this.isDecimal = data;
    }

    /**
     * Getter method of screenValue variable
     *
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
     *
     * @param decimalDigitCount - value which should be set to decimalDigitCount variable
     */
    public void setDecimalDigitCount(int decimalDigitCount) {
        this.decimalDigitCount = decimalDigitCount;
    }

    /**
     * Getter for decimalDigitCount variable
     *
     * @return decimalDigitCount - value which should be set to decimalDigitCount variable
     */
    public int getDecimalDigitCount() {
        return this.decimalDigitCount;
    }

    /**
     * Setter for screenValue variable
     *
     * @param screenValue - value which should be set to screenValue variable
     */
    public void setScreenValue(double screenValue) {
        this.screenValue = screenValue;
    }

    /**
     * Method which return value of screeValue for one symbol back (BACKSPACE button clicked)
     */
    public void backspace() {
        if (this.isDecimal && this.getDecimalDigitCount() > 0) {
            int val = getLastValuesAfterPoint();

            this.screenValue = this.getSignOfScreenValue() * (Math.abs(this.screenValue) - (Math.pow(0.1, this.decimalDigitCount) * val));
            --this.decimalDigitCount;
        } else {
            this.screenValue = Math.ceil(this.screenValue / 10);
        }

        if (this.screenValue == 0) {
            calculator.clear();
        }
    }

    /**
     * Method which return last digit from double number
     *
     * @return - int last digit of number
     */
    private int getLastValuesAfterPoint() {
        String format = "%." + this.decimalDigitCount + "f";
        String str = String.valueOf(String.format(format, Math.abs(this.screenValue)));
        String lastElem = str.substring(str.length() - 1);

        int ret = Integer.valueOf(lastElem);

        return ret;
    }

    /**
     * Method which detects sign of screenValue
     *
     * @return - int 1 if value is more 0, -1 if value is less then 0
     */
    private double getSignOfScreenValue() {
        double sign = 1.00;
        if (this.screenValue < 0) {
            sign = -1.00;
        }

        return sign;
    }
}

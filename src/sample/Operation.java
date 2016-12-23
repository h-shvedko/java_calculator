package sample;

/**
 * Created by hshvedko on 14-Dec-16.
 */
public class Operation {

    private Calculator calculator;
    private InputNumber inputNumber;
    private static final String OPERATION_PLUS = "plus";
    private static final String OPERATION_EQUAL = "equal";
    private static final String OPERATION_MINUS = "minus";
    private static final String OPERATION_MULTIPLY = "multiply";
    private static final String OPERATION_DIVIDE = "division";
    private static final String OPERATION_CHANGE_SIGN = "changeSign";
    private static final String OPERATION_SQRT = "sqrt";
    private static final String OPERATION_BACKSPACE = "backspace";
    private static final String OPERATION_ONE_DIVIDE = "oneDivide";
    private static final String OPERATION_DOUBLE_NULL = "doubleNull";
    private static final String OPERATION_CLEAR = "clear";
    private static final String OPERATION_POINT = "point";

    public Operation(){
        this.calculator = new Calculator();
        this.inputNumber = new InputNumber(this.calculator);
    }

    public double calculate(String id) {
        switch (id){
            case OPERATION_PLUS:
                calculator.plus();
                break;
            case OPERATION_MINUS:
                calculator.minus();
                break;
            case OPERATION_DIVIDE:
                calculator.divide();
                break;
            case OPERATION_MULTIPLY:
                calculator.muliply();
                break;
            case OPERATION_POINT:
                inputNumber.point();
                break;
            case OPERATION_EQUAL:
                calculator.equal();
                break;
            case OPERATION_CLEAR:
                calculator.clear();
                break;
            case OPERATION_CHANGE_SIGN:
                calculator.changeSign();
                break;
            default:
                inputNumber.input(Integer.parseInt(id));
                break;
        }

        double number = inputNumber.getScreenValue();

        return number;
    }
}

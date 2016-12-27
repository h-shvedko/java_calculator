package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLCalculatorController {

    /**
     * Instance of Label class
     */
    @FXML
    private Label actiontarget;

    /**
     * Instance of Operation class
     */
    private Operation operation;

    /**
     * Constructor of FXMLCalculatorController class
     */
    public FXMLCalculatorController() {
        this.operation = new Operation();
    }

    /**
     * OnClick handler for any button of application
     *
     * @param actionEvent - instance of ActionEvent class
     */
    public void handleClickOnNumberButton(ActionEvent actionEvent) {
        Button x = (Button) actionEvent.getSource();
        String id = x.getId();

        double number = this.operation.calculate(id);
        String str = getStringFromNumber(number);
        actiontarget.setText(str);
    }

    /**
     * Method which formatted our output value due to number of decimal numbers
     *
     * @param number - output value
     * @return - formatted output value
     */
    private String getStringFromNumber(double number) {
        String ret;
        int numberAfterPoint = 0;
        boolean ifInput = this.operation.isIfInput();

        if(ifInput){
            numberAfterPoint = this.operation.getDecimalDigitCount();
        } else {
            numberAfterPoint = this.operation.getDecimalDigitCount() + this.operation.getDecimalSecondDigitCount();
        }

        String format = "%." + numberAfterPoint + "f";
        ret = String.valueOf(String.format(format, number));

        return ret;

    }

    private boolean hasValuesAfterPoint(double number){
        boolean ret = false;
        if((number - Math.ceil(number)) != 0){
            ret = true;
        }
        return ret;
    }


}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLCalculatorController {

    /**
     * Instance of Label class
     */
    @FXML private Label actiontarget;

    /**
     * Instance of Operation class
     */
    private Operation operation;

    /**
     * Constructor of FXMLCalculatorController class
     */
    public FXMLCalculatorController(){
        this.operation = new Operation();
    }

    /**
     * OnClick handler for any button of application
     * @param actionEvent - instance of ActionEvent class
     */
    public void handleClickOnNumberButton(ActionEvent actionEvent) {
        Button x = (Button) actionEvent.getSource();
        String id = x.getId();

        double number = this.operation.calculate(id);
        actiontarget.setText(String.valueOf(number));
    }
}

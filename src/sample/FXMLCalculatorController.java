package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLCalculatorController {

    @FXML private Label actiontarget;

    private Operation operation;

    public FXMLCalculatorController(){
        this.operation = new Operation();
    }
//
//    @FXML public void handleSubmitButtonAction(ActionEvent actionEvent) {
//        actiontarget.setText("Sign in button pressed");
//    }

    public void handleClickOnNumberButton(ActionEvent actionEvent) {
        Button x = (Button) actionEvent.getSource();
        String id = x.getId();

        double number = this.operation.calculate(id);
        actiontarget.setText(String.valueOf(number));
    }
}

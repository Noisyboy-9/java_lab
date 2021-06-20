package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

/**
 * The type Calculator controller.
 */
public class CalculatorController {
    @FXML
    public TextField textField;
    @FXML
    private Button clickedOperationButton = null;
    private Float result = null;

    /**
     * Handle ac operator click event.
     */
    public void handleAcOperatorClickEvent() {
        this.textField.setText("");
        this.result = null;
    }

    /**
     * Handle number clicked event.
     *
     * @param mouseEvent the mouse event
     */
    public void handleNumberClickedEvent(MouseEvent mouseEvent) {
        Button clickedButton = (Button) mouseEvent.getSource();
        this.textField.setText(
                this.textField.getText().concat(clickedButton.getText())
        );

    }

    /**
     * Handle float operator click event.
     */
    public void handleFloatOperatorClickEvent() {
        this.textField.setText(
                this.textField.getText().concat(".")
        );
    }

    /**
     * Handle sum operator click event.
     *
     * @param event the event
     */
    public void handleSumOperatorClickEvent(MouseEvent event) {
        if (Objects.isNull(this.result)) {
            this.setResult();
            this.clickedOperationButton = (Button) event.getSource();
            return;
        }

//        user is entering the second number have to calculate the sum.
        float operand = Float.parseFloat(this.textField.getText());
        this.result += operand;

        this.updateUi();
    }

    /**
     * Handle subtract click event.
     *
     * @param event the event
     */
    public void handleSubtractClickEvent(MouseEvent event) {
        if (Objects.isNull(this.result)) {
            this.setResult();
            this.clickedOperationButton = (Button) event.getSource();
            return;
        }

        float operand = Float.parseFloat(this.textField.getText());
        this.result -= operand;

        this.updateUi();
    }

    /**
     * Handle cross operator click event.
     *
     * @param event the event
     */
    public void handleCrossOperatorClickEvent(MouseEvent event) {
        if (Objects.isNull(this.result)) {
            this.setResult();
            this.clickedOperationButton = (Button) event.getSource();
            return;
        }

        float operand = Float.parseFloat(this.textField.getText());
        this.result = this.result * operand;

        this.updateUi();
    }

    /**
     * Handle equal operator click event.
     */
    public void handleEqualOperatorClickEvent() {
        if (Objects.isNull(this.clickedOperationButton)) {
//            user has incorrectly clicked the equals operator button
            return;
        }

        float operand = Float.parseFloat(this.textField.getText());

        if (this.clickedOperationButton.getText().equals("+")) {
            this.result += operand;
        }

        if (this.clickedOperationButton.getText().equals("-")) {
            this.result -= operand;
        }

        if (this.clickedOperationButton.getText().equals("x")) {
            this.result *= operand;
        }

        if (this.clickedOperationButton.getText().equals("/")) {
            this.result /= operand;
        }

        this.updateUi();
        this.clickedOperationButton = null;
    }

    /**
     * Handle division operator click event.
     *
     * @param event the event
     */
    public void handleDivisionOperatorClickEvent(MouseEvent event) {
        if (Objects.isNull(this.result)) {
            this.setResult();
            this.clickedOperationButton = (Button) event.getSource();
            return;
        }

        float operand = Float.parseFloat(this.textField.getText());
        this.result /= operand;

        this.updateUi();
    }

    private void setResult() {
        //            user is entering the first number, have to save it
        this.result = Float.parseFloat(this.textField.getText());
        this.textField.clear();
    }

    private void updateUi() {
        if (this.isInteger(this.result)) {
//            the result of the sum was a integer so must write a integer to text field
            this.textField.setText(String.valueOf(this.result.intValue()));
            return;
        }

        this.textField.setText(this.result.toString());
    }

    private boolean isInteger(float number) {
        return (int) number == number;
    }
}

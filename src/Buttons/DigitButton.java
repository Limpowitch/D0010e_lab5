package Buttons;

import javax.swing.JLabel;

import General.CalculatorButton;
import State.Situation;
import State.State;

/**
 * Child class which inherits CalculatorButton
 * Generates a digit-button which when pressed updates the JPanel with the integer value of the digit-button
 */
public class DigitButton extends CalculatorButton {

    public DigitButton(String string, Situation situation) {
        super(string, situation);
    }

    /**
     * Switch case to handle the 4 different states of the calculator
     * Input1 and 2 behaves the same. They update the JPanel with the inputed value of the digit-buttons
     */
    @Override
    public void transition() {
        JLabel textfield = situation.getDisplay();
        
        switch (situation.getState()) {
            case Input1:
            case Input2:
                if (textfield.getText().equals("0")) {
                    textfield.setText(this.toString());
                } else {
                    textfield.setText(textfield.getText() + this.toString());
                }
                situation.updateState(State.Input1); 
                break;

            case OpReady:
                textfield.setText(this.toString());
                situation.updateState(State.Input2);
                break;

            case HasResult:
                textfield.setText(this.toString());
                situation.updateState(State.Input1);
                break;
        }
    }
}

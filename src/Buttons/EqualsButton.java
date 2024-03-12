/**
 * @author Tim Rosendahl
 * @author Bernhard Rosenzweig
 */

package Buttons;

import java.awt.Color;

import javax.swing.JLabel;

import General.CalculatorButton;
import State.Situation;
import State.*;

/**
 * Child class which inherits CalculatorButton
 * Generates a equals button which gives the final result of the left and right operand applied to a binary operator
 */
public class EqualsButton extends CalculatorButton {

    public EqualsButton(String string, Situation situation) {
        super(string, situation);
    }

    /**
     * Switch case method which handles the 4 different states of the calculator
     * If we're in Input 2, we apply the operation using the helper method applyOperation from BinOpButton
     * A try catch makes sure we can't do division by zero
     */
    @Override
    public void transition() {
        JLabel textfield = situation.getDisplay();

        switch (situation.getState()) {
            case Input1:
            case Input2:
                try {
                    int result = situation.getBinaryOperator().applyOperation(situation.getLeftOperand(), Integer.parseInt(textfield.getText()));
                    textfield.setText(Integer.toString(result));
                    situation.getBinaryOperator().setColor(Color.black);
                } catch (NumberFormatException e) {
                    textfield.setText("Invalid Input");
                } catch (ArithmeticException e) {
                    textfield.setText("Error: Division by Zero");
                }
                situation.updateState(State.HasResult);
                break;

            case OpReady:
            	//Gör inget
            case HasResult:
                situation.updateState(situation.getState());
                situation.getBinaryOperator().setColor(Color.black);
                break;
        }
    }
}
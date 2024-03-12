/**
 * @author Tim Rosendahl
 * @author Bernhard Rosenzweig
 */

package Buttons;

import General.CalculatorButton;
import State.Situation;
import State.State;

import java.awt.Color;

/**
 * Child class which inherits CalculatorButton
 * Generates a cancel-button which zeroes the current JPanel
 */
public class CancelButton extends CalculatorButton {

	/**
	 * Constructor of the cancel-button
	 * @param string The string value which should be displayed on the button (c in this case)
	 * @param situation The current situation of the calculator
	 */
    public CancelButton(String string, Situation situation) {
        super(string, situation);
    }

    /**
     * Switch case which handles the 4 different states of the calculator
     * Since the cancel-button behaves the same across all states, all cases behave like HasResult
     */
    @Override
    public void transition() {
        situation.getDisplay().setText("0");
        situation.setLeftOperand(0);

        switch (situation.getState()) {
            case Input1:
            	situation.updateState(State.Input1);
                break;
            case OpReady:
            case Input2:
            case HasResult:
                situation.updateState(State.Input1);
            	situation.getBinaryOperator().setColor(Color.black);
                situation.setBinaryOperator(null);
                break;
        }
    }
}

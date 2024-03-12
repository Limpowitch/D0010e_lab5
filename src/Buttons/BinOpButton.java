/**
 * @author Tim Rosendahl
 * @author Bernhard Rosenzweig
 */

package Buttons;

import java.awt.Color;
import java.util.function.IntBinaryOperator;

import javax.swing.JLabel;

import General.CalculatorButton;
import State.Situation;
import State.State;

/**
 * Child class which inherits CalculatorButton
 * Generates a binary operation button
 */
public class BinOpButton extends CalculatorButton {
    private IntBinaryOperator intBinaryOperator;

    /**
     * Constructor of the BinOpButton
     * @param intBinaryOperator The specific binary operator which the button should utilize
     * @param string The string value which should be displayed on the button (+ - * /)
     * @param situation The current situation of the calculator
     */
    public BinOpButton(IntBinaryOperator intBinaryOperator, String string, Situation situation) {
        super(string, situation);
        this.intBinaryOperator = intBinaryOperator;
    }
    
    /**
     * Helper method for calculations
     * @param a The left operand
     * @param b The right operand
     * @return Returns the integer value of a performed binary operation 
     */
    public int applyOperation(int a, int b){
		return intBinaryOperator.applyAsInt(a, b);
	}

    /**
     * Switch state which different responses to the current state of the calculator
     * Has the function of setting the current binary operand and storing it in situation
     */
    @Override
    public void transition() {
        switch (situation.getState()) {
            case Input1:
            case HasResult:
                situation.setLeftOperand(Integer.parseInt(situation.getDisplay().getText()));
                situation.setBinaryOperator(this);
                situation.updateState(State.OpReady);
                this.setColor(Color.red);
                break;

            case OpReady:
                situation.getBinaryOperator().setColor(Color.black);
                situation.setBinaryOperator(this);
                this.setColor(Color.red);
                break;

            case Input2:
                situation.getDisplay().setText("0");
                situation.updateState(State.Input2);
                break;
        }
    }
}

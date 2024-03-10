package State;

import javax.swing.JLabel;

import Buttons.BinOpButton;


/**
 * Class to store the specific state variables of the calculator
 */
public class Situation {
	State state = State.Input1;
	JLabel display;
	BinOpButton binaryOperator;
	int leftOperand;
	private String printOperator;
	
	/**
	 * Constructor for Situation
	 * @param display The generated JLabel display from the GUI class
	 */
	public Situation(JLabel display) {
		this.display = display;
	}
	
	/**
	 * 
	 * @return Returns the JLabel display of the calculator
	 */
	public JLabel getDisplay() {
		return this.display;
	}
	
	/**
	 * Method to set the left operand to the integer value a
	 * @param a The left operand of the calculator (for example in A * B, A would be the left operand) 
	 */
	public void setLeftOperand(int a) {
		this.leftOperand = a;
	}
	
	/**
	 * Method to return the left operand of the calculator
	 * @return Returns the left operand of the calculator
	 */
	public int getLeftOperand() {
		return this.leftOperand;
	}
	
	/**
	 * Method to update the current binary operator
	 * @param binaryOperator The specific binary operator which should be stored in Situation
	 */
	public void setBinaryOperator(BinOpButton binaryOperator) {
		this.binaryOperator = binaryOperator;
	}
	
	/**
	 * Method to return binary operator
	 * @return Returns the specific binary operator stored in Situation
	 */
	public BinOpButton getBinaryOperator() {
		return this.binaryOperator;
	}
	
	/**
	 * Updates the current state of the calculator with one of the 4 specific states in State.State.java
	 * @param newState The specific state
	 */
	public void updateState(State newState) {
		this.state = newState;
	}

	/**
	 * Method to return the current state of the calculator
	 * @return Returns the one of the 4 specific states from State.State.java which is stored in Situation 
	 */
	public State getState() {
		return this.state;
	}

}

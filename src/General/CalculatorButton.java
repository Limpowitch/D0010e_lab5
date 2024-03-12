/**
 * @author Tim Rosendahl
 * @author Bernhard Rosenzweig
 */

package General;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import General.*;
import State.*;

/**
 * Generic parent class which represents a calculator button
 */
public abstract class CalculatorButton extends JButton implements ActionListener{
	protected Situation situation;
	
	/**
	 * Abstract method which children will fill with specific instructions
	 */
	public abstract void transition();
	
	/**
	 * Constructor of calculator button
	 * @param string The desired button value (0-9, + - * /) which should be displayed on the button
	 * @param situation The current situation of the calculator
	 */
	public CalculatorButton(String string, Situation situation) {
		super(string);
		this.situation = situation;
		this.setPreferredSize(new Dimension(100, 100));
		
		this.setBackground(Color.WHITE);
		this.setFont(new Font("Dialog", Font.PLAIN, 30));
		this.addActionListener(this);
		this.setColor(Color.BLACK);
	}
	
	/**
	 * Function to update the border-color of a button
	 * @param color The desired color which should be updated to a button
	 */
	public void setColor(Color color){
        this.setBorder(new LineBorder(color,2));
    }

//    public void setBorder(Color color){
//        setBorder(BorderFactory.createLineBorder(color));
//    }

	/**
	 * Method to return the current text value in the JLabel 
	 */
    @Override
    public String toString(){
        return this.getText();
    }

    /**
     * Imported method from ActionListner
     * Calls the transition method everytime a event is triggered 
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		transition();
	}
	
}

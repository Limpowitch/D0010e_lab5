package General;

import javax.swing.*;
import java.awt.*;
import Buttons.*;
import State.Situation;


/**
 * Class which generates a JFrame, JLabel, and JPanel for the calculator.
 * The JFrame represents the body of the calculator.
 * The JLabel represents the input/output window of the calculator.
 * The JPanel represents the buttons of the calculator
 */
public class GUI extends JFrame {
    private JLabel calculatorDisplay;
    private JPanel calculatorKeyPad;

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Calculator");
        setLayout(null);
        setSize(500, 600);

        calculatorDisplay = new JLabel("0", SwingConstants.RIGHT);
        calculatorDisplay.setFont(new Font("Dialog", Font.PLAIN, 30));
        calculatorDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        calculatorDisplay.setBounds(25, 25, 450, 50);
        Situation situation = new Situation(calculatorDisplay);

        calculatorKeyPad = new JPanel(new GridLayout(4, 4, 5, 5));
        calculatorKeyPad.setBounds(25, 90, 450, 430);
        calculatorKeyPad.setBackground(Color.GRAY);

        addButton(new DigitButton("7", situation));
        addButton(new DigitButton("8", situation));
        addButton(new DigitButton("9", situation));
        addButton(new BinOpButton((a, b) -> a / b, "/", situation));

        addButton(new DigitButton("4", situation));
        addButton(new DigitButton("5", situation));
        addButton(new DigitButton("6", situation));
        addButton(new BinOpButton((a, b) -> a * b, "*", situation));

        addButton(new DigitButton("1", situation));
        addButton(new DigitButton("2", situation));
        addButton(new DigitButton("3", situation));
        addButton(new BinOpButton((a, b) -> a - b, "-", situation));

        addButton(new DigitButton("0", situation));
        addButton(new EqualsButton("=", situation));
        addButton(new CancelButton("C", situation));
        addButton(new BinOpButton((a, b) -> a + b, "+", situation));

        add(calculatorDisplay);
        add(calculatorKeyPad);
        setVisible(true);
    }

    /**
     * Separate method to increase readability which has the purpose of adding buttons to the JPanel
     * 
     * @param button The button which will be added to the calculator JPanel
     */
    private void addButton(CalculatorButton button) {
        calculatorKeyPad.add(button);
    }
}
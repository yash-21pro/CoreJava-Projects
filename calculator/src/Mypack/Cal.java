package Mypack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Cal  extends JFrame implements ActionListener{



	    JTextField display;
	    double num1 = 0, num2 = 0;
	    String operator = "";

	    public Cal() {

	        setTitle(" Calculator");
	        setSize(350, 500);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        
	        display = new JTextField();
	        display.setFont(new Font("Arial", Font.BOLD, 30));
	        display.setHorizontalAlignment(SwingConstants.RIGHT);
	        display.setEditable(false);
	        add(display, BorderLayout.NORTH);

	        
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(6, 4, 5, 5));
	        panel.setBackground(Color.BLACK);

	        String buttons[] = {
	                "C", "⌫", "%", "/",
	                "7", "8", "9", "*",
	                "6", "5", "4", "-",
	                "1", "2", "3", "+",
	                "00", "0", ".", "="
	        };

	        for (String text : buttons) {
	            JButton btn = new JButton(text);
	            btn.setFont(new Font("Arial", Font.BOLD, 22));
	            btn.setFocusable(false);
	            btn.addActionListener(this);
	            panel.add(btn);
	        }

	        add(panel, BorderLayout.CENTER);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {

	        String input = e.getActionCommand();

	        
	        if (input.equals("C")) {
	            display.setText("");
	            num1 = num2 = 0;
	            operator = "";
	            return;
	        }

	        
	        if (input.equals("⌫")) {
	            String text = display.getText();
	            if (text.length() > 0)
	                display.setText(text.substring(0, text.length() - 1));
	            return;
	        }

	       
	        if (input.equals("+") || input.equals("-") || input.equals("*") ||
	                input.equals("/") || input.equals("%")) {

	            try {
	                num1 = Double.parseDouble(display.getText());
	            } catch (Exception ex) {
	                num1 = 0;
	            }
	            operator = input;
	            display.setText("");
	            return;
	        }

	       
	        if (input.equals("=")) {
	            try {
	                num2 = Double.parseDouble(display.getText());
	            } catch (Exception ex) {
	                num2 = 0;
	            }

	            double result = 0;

	            switch (operator) {
	                case "+": result = num1 + num2; break;
	                case "-": result = num1 - num2; break;
	                case "*": result = num1 * num2; break;
	                case "/": 
	                    if (num2 == 0) {
	                        display.setText("Cannot divide by Zero");
	                        return;
	                    }
	                    result = num1 / num2;
	                    break;
	                case "%": result = num1 % num2; break;
	            }

	            display.setText(String.valueOf(result));
	            operator = "";
	            return;
	        }
	        display.setText(display.getText() + input);
	    }

	    public static void main(String[] args) {
	        new Cal().setVisible(true);
	    }
	}




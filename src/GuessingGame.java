import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Try again.";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else
				message = guess + " is correct. You win! Let's play again!";
			
			newGame();
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		}finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}

	}
	public void newGame() {
		Random r = new Random();
		theNumber = (int)r.nextInt(100)+1;
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Viktor Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblguessANumber = new JLabel("Guess a number between 1 and 100:");
		lblguessANumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblguessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblguessANumber.setBounds(10, 85, 339, 14);
		getContentPane().add(lblguessANumber);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtGuess.setBounds(359, 87, 75, 14);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnGuess.addActionListener((ActionListener) new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnGuess.setBounds(173, 121, 89, 23);
		getContentPane().add(btnGuess);


		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblOutput.setBounds(10, 217, 414, 14);
		getContentPane().add(lblOutput);

		JLabel lblViktorHilo = new JLabel("Viktor Hi-Lo Guessing Game");
		lblViktorHilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblViktorHilo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblViktorHilo.setBounds(10, 30, 414, 25);
		getContentPane().add(lblViktorHilo);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}

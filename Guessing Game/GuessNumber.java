import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuessNumber extends JFrame {
	private JTextField tfNum, tfGuess;
	private int max = 100;
	private int min = 1;
	private int range = max - min + 1;
	private JLabel lblGuess;
	private int rand;
	private String randStr;

	public GuessNumber() {

		for (int i = 0; i < max; i++) {
			rand = (int) (Math.random() * range) + min;
		}

		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("The Number is "));

		tfNum = new JTextField("", 10);
		tfNum.setEditable(false);
		tfNum.setHorizontalAlignment(JTextField.RIGHT);
		cp.add(tfNum);

		JButton btnGenerate = new JButton("Generate");
		cp.add(btnGenerate);
		btnGenerate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rand >= 1 && rand < 10)
					randStr = "*";
				else if (rand >= 10 && rand < 100)
					randStr = "**";
				else if (rand == 100)
					randStr = "***";
				else
					throw new AssertionError();
				tfNum.setText(randStr);
			}
		});

		cp.add(new JLabel("Enter your guess between 1-100"));

		tfGuess = new JTextField("", 10);
		tfGuess.setHorizontalAlignment(JTextField.RIGHT);
		cp.add(tfGuess);

		lblGuess = new JLabel("");
		cp.add(lblGuess);

		tfGuess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Integer.parseInt(tfGuess.getText()) == rand) {
					lblGuess.setText("You Got It!");
				}

				else if (Integer.parseInt(tfGuess.getText()) < rand) {
					lblGuess.setText("Try Higher! ");
				}

				else
					lblGuess.setText("Try Lower!");

			}
		});

		setVisible(true);
		setTitle("Guess The Number");
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GuessNumber();
	}
}

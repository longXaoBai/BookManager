package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class NoSearchBook extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public NoSearchBook() {
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("警告");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.BLACK);
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 202, 434, 59);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton button = new JButton("确认");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NoSearchBook.this.dispose();
					}
				});
				button.setForeground(Color.BLACK);
				button.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
				button.setBackground(Color.WHITE);
				button.setActionCommand("OK");
				button.setBounds(170, 10, 96, 39);
				buttonPane.add(button);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("没有这本书");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
			lblNewLabel.setBounds(118, 24, 211, 48);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("_(:з」∠)_");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
			lblNewLabel.setBounds(108, 114, 249, 48);
			contentPanel.add(lblNewLabel);
		}
	}

}

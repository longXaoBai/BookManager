package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Success extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Success() {
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("成功");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 202, 434, 59);
			contentPanel.add(buttonPane);
			{
				JButton okButton = new JButton("确认");
				okButton.setForeground(Color.BLACK);
				okButton.setBackground(Color.WHITE);
				okButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
				okButton.setBounds(168, 10, 96, 39);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Success.this.dispose();
					}
				});
				buttonPane.setLayout(null);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("成功么么哒！");
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
			lblNewLabel.setBounds(103, 43, 251, 48);
			contentPanel.add(lblNewLabel);
		}
	}

}

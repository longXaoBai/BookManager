package GUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class Eggshell extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Eggshell() {
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.BLACK);
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("��������");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.WHITE);
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setBounds(0, 202, 434, 59);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("ȷ��");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Eggshell.this.dispose();
					}
				});
				okButton.setFont(new Font("������������", Font.PLAIN, 30));
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(Color.BLACK);
				okButton.setBounds(165, 10, 96, 39);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("С���Ӳ�Ҫ�ҵ㣡");
			lblNewLabel.setFont(new Font("������������", Font.PLAIN, 40));
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(62, 30, 333, 48);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("�۸���ô��ģ����ѯ��");
		lblNewLabel_1.setFont(new Font("������������", Font.PLAIN, 40));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(31, 119, 414, 48);
		contentPanel.add(lblNewLabel_1);
	}
}

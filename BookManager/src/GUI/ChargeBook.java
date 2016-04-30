package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

import MODEL.Book;
import OPERATION.Operation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ChargeBook extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField newIdTextField;
	private JTextField booknameTextField;
	private JTextField authorTextField;
	private JTextField priceTextField;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Create the dialog.
	 */
	public ChargeBook(final String oldId) {
		setTitle("修改界面");
		setAlwaysOnTop(true);
		setModal(true);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setBounds(100, 100, 600, 400);
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
			buttonPane.setBounds(0, 302, 584, 59);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("修改");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Operation op = new Operation();
						String newId = newIdTextField.getText();
						String bookname = booknameTextField.getText();
						String author = authorTextField.getText();
						String price = priceTextField.getText();
						Book book = new Book(newId,bookname,author,Float.valueOf(price));
						if(op.charge(book, oldId)){
							Success chargeBookSuccess = new Success();
							chargeBookSuccess.setVisible(true);
							ChargeBook.this.dispose();
						}
						else{
							Fail addBookFail = new Fail();
							addBookFail.setVisible(true);
						}
					}
				});
				okButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 25));
				okButton.setForeground(Color.BLACK);
				okButton.setBackground(Color.WHITE);
				okButton.setBounds(78, 10, 96, 39);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ChargeBook.this.dispose();
					}
				});
				cancelButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 25));
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setBounds(406, 10, 96, 39);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			newIdTextField = new JTextField();
			newIdTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			newIdTextField.setColumns(10);
			newIdTextField.setBounds(215, 21, 289, 57);
			contentPanel.add(newIdTextField);
		}
		{
			booknameTextField = new JTextField();
			booknameTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			booknameTextField.setColumns(10);
			booknameTextField.setBounds(215, 88, 289, 57);
			contentPanel.add(booknameTextField);
		}
		{
			authorTextField = new JTextField();
			authorTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			authorTextField.setColumns(10);
			authorTextField.setBounds(215, 155, 289, 57);
			contentPanel.add(authorTextField);
		}
		{
			priceTextField = new JTextField();
			priceTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			priceTextField.setColumns(10);
			priceTextField.setBounds(215, 222, 289, 57);
			contentPanel.add(priceTextField);
		}
		{
			label = new JLabel("编号：");
			label.setForeground(Color.BLACK);
			label.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			label.setBackground(Color.WHITE);
			label.setBounds(125, 21, 90, 57);
			contentPanel.add(label);
		}
		{
			label_1 = new JLabel("图书名：");
			label_1.setForeground(Color.BLACK);
			label_1.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			label_1.setBackground(Color.WHITE);
			label_1.setBounds(95, 88, 120, 57);
			contentPanel.add(label_1);
		}
		{
			label_2 = new JLabel("作者名：");
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			label_2.setBackground(Color.WHITE);
			label_2.setBounds(95, 155, 120, 57);
			contentPanel.add(label_2);
		}
		{
			label_3 = new JLabel("单价：");
			label_3.setForeground(Color.BLACK);
			label_3.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			label_3.setBackground(Color.WHITE);
			label_3.setBounds(125, 222, 90, 57);
			contentPanel.add(label_3);
		}
	}

}

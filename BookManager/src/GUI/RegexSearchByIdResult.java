package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;

import MODEL.Book;
import MODEL.BookList;
import OPERATION.Operation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegexSearchByIdResult extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable resultTable;

	/**
	 * Create the dialog.
	 */
	public RegexSearchByIdResult(String id) {
		setTitle("���ҽ��");
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 800, 500);
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
			buttonPane.setBounds(0, 402, 784, 59);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton yesButton = new JButton("ȷ��");
				yesButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegexSearchByIdResult.this.dispose();
					}
				});
				yesButton.setForeground(Color.WHITE);
				yesButton.setFont(new Font("������������", Font.PLAIN, 30));
				yesButton.setBackground(Color.BLACK);
				yesButton.setActionCommand("OK");
				yesButton.setBounds(337, 10, 96, 39);
				buttonPane.add(yesButton);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 764, 380);
		contentPanel.add(scrollPane);
		
		resultTable = new JTable();
		resultTable.setFont(new Font("������������", Font.PLAIN, 20));
		resultTable.setRowHeight(30);
		resultTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"���", "����", "����", "����"
			}
		));
		
		Book book = new Book(id,null,null,0);
		BookList booklist = new Operation().regexSearchById(book);
		for(int i = 0; i<booklist.size(); i++){
			DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
			tableModel.addRow(new Object[]{ booklist.get(i).id, booklist.get(i).bookname, booklist.get(i).author, booklist.get(i).price});
		}
		
		resultTable.setForeground(Color.WHITE);
		resultTable.setBackground(Color.BLACK);
		scrollPane.setViewportView(resultTable);
	}
}

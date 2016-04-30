package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;

import MODEL.Book;
import MODEL.BookList;
import OPERATION.Operation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchByPriceResult extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable resultTable;

	/**
	 * Create the dialog.
	 */
	public SearchByPriceResult(String lowPrice,String highPrice) {
		setTitle("查询结果");
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 800, 500);
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
			buttonPane.setBounds(0, 402, 784, 59);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton button = new JButton("确认");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SearchByPriceResult.this.dispose();
					}
				});
				button.setForeground(Color.BLACK);
				button.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
				button.setBackground(Color.WHITE);
				button.setActionCommand("OK");
				button.setBounds(337, 10, 96, 39);
				buttonPane.add(button);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 764, 382);
		contentPanel.add(scrollPane);
		
		resultTable = new JTable();
		resultTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"编号", "书名", "作者", "单价"
			}
		));
		
		Operation op = new Operation();
		Book lowBook = new Book(null,null,null,Float.valueOf(lowPrice));
		Book highBook = new Book(null,null,null,Float.valueOf(highPrice));
		BookList booklist = op.searchByPrice(lowBook, highBook);
		for(int i = 0; i<booklist.size(); i++){
			DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
			tableModel.addRow(new Object[]{ booklist.get(i).id, booklist.get(i).bookname, booklist.get(i).author, booklist.get(i).price});
		}
		
		resultTable.setFont(new Font("方正咆哮简体", Font.PLAIN, 20));
		resultTable.setForeground(Color.BLACK);
		resultTable.setBackground(Color.WHITE);
		scrollPane.setViewportView(resultTable);
	}
}

package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import MODEL.Book;
import MODEL.BookList;
import OPERATION.Operation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class UltimateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;
	private JTable resultTable;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UltimateFrame frame = new UltimateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Book getBook(int rowCount){
		DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
		Book book=new Book((String)tableModel.getValueAt(rowCount, 0),(String)tableModel.getValueAt(rowCount, 1),(String)tableModel.getValueAt(rowCount, 2),Float.valueOf((String)tableModel.getValueAt(rowCount, 3)));
		return book;
	}

	public class DeleteButtonRender implements TableCellRenderer{
	    private JPanel panel;
	    private JButton button;
	    
	    public DeleteButtonRender(){
	        this.initButton();
	        this.initPanel();
	        this.panel.add(this.button);
	    }

	    private void initButton(){
	        this.button = new JButton();
	        this.button.setForeground(Color.BLACK);
	        this.button.setBackground(Color.WHITE);
	    }

	    private void initPanel(){
	        this.panel = new JPanel();
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,int column){
	        this.button.setText("删除");
	        this.button.setFont(new Font("宋体", Font.PLAIN, 13));
	        return this.button;
	    }
	}
	
	public class DeleteButtonEditor extends DefaultCellEditor { 
	    /**
	     * serialVersionUID
	     */ 
	    private static final long serialVersionUID = -6546334664166791132L; 
	 
	    private JPanel panel; 
	 
	    private JButton button; 
	 
	    public DeleteButtonEditor() 
	    { 
	        // DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。  
	        super(new JTextField()); 
	 
	        // 设置点击几次激活编辑。  
	        this.setClickCountToStart(1); 
	 
	        this.initButton(); 
	 
	        this.initPanel();
	        
	        // 添加按钮。  
	        this.panel.add(this.button); 
	    } 
	 
	    private void initButton() 
	    { 
	        this.button = new JButton(); 
	        
	        // 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。  
	        this.button.addActionListener(new ActionListener() 
	        { 
	            public void actionPerformed(ActionEvent e) 
	            { 
	                // 触发取消编辑的事件，不会调用tableModel的setValue方法。  
	                DeleteButtonEditor.this.fireEditingCanceled(); 
	                DefaultTableModel tableModel = (DefaultTableModel) UltimateFrame.this.resultTable.getModel();
	                String id=(String) tableModel.getValueAt(UltimateFrame.this.resultTable.getSelectedRow(), 0);
	                Book book = new Book(id,null,null,0);
	                Operation op = new Operation();
	                op.deleteById(book);
	                tableModel.removeRow(UltimateFrame.this.resultTable.getSelectedRow());
	                // 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。  
	            } 
	        }); 
	    } 
	 
	    private void initPanel() 
	    { 
	        this.panel = new JPanel(); 
	    } 
	 
	 
	    /**
	     * 这里重写父类的编辑方法，返回一个JPanel对象即可（也可以直接返回一个Button对象，但是那样会填充满整个单元格）
	     */ 
	    @Override 
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
	    { 
	        // 只为按钮赋值即可。也可以作其它操作。  
	        this.button.setText("删除");
	        this.button.setFont(new Font("宋体", Font.PLAIN, 13));
	        return this.button; 
	    } 
	 
	    /**
	     * 重写编辑单元格时获取的值。如果不重写，这里可能会为按钮设置错误的值。
	     */ 
	    @Override 
	    public Object getCellEditorValue() 
	    { 
	        return this.button.getText(); 
	    } 
	}  
	
	public class UpdateButtonRender implements TableCellRenderer{
		
	    private JPanel panel;
	    private JButton button;
	    
	    public UpdateButtonRender(){
	        this.initButton();
	        this.initPanel();
	        this.panel.add(this.button);
	    }

	    private void initButton(){
	        this.button = new JButton();
	        this.button.setForeground(Color.BLACK);
	        this.button.setBackground(Color.WHITE);
	    }

	    private void initPanel(){
	        this.panel = new JPanel();
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,int column){
	        this.button.setText("修改");
	        this.button.setFont(new Font("宋体", Font.PLAIN, 13));
	        return this.button;
	    }
	}
	
	public class UpdateButtonEditor extends DefaultCellEditor { 
	    /**
	     * serialVersionUID
	     */ 
	    private static final long serialVersionUID = -6546334664166791132L; 
	 
	    private JPanel panel; 
	 
	    private JButton button; 
	 
	    public UpdateButtonEditor() 
	    { 
	        // DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。  
	        super(new JTextField()); 
	 
	        // 设置点击几次激活编辑。  
	        this.setClickCountToStart(1); 
	 
	        this.initButton(); 
	 
	        this.initPanel();
	        
	        // 添加按钮。  
	        this.panel.add(this.button); 
	    } 
	 
	    private void initButton() 
	    { 
	        this.button = new JButton(); 
	        
	        // 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。  
	        this.button.addActionListener(new ActionListener() 
	        { 
	            public void actionPerformed(ActionEvent e) 
	            { 
	                // 触发取消编辑的事件，不会调用tableModel的setValue方法。  
	            	UpdateButtonEditor.this.fireEditingCanceled(); 
	            	DefaultTableModel tableModel = (DefaultTableModel) UltimateFrame.this.resultTable.getModel();
	            	String id=(String) tableModel.getValueAt(UltimateFrame.this.resultTable.getSelectedRow(), 0);
	            	Book book = UltimateFrame.this.getBook(UltimateFrame.this.resultTable.getSelectedRow());
	            	Book oldBook = new Book(id,null,null,0);
	            	Operation op = new Operation();
	            	if(op.searchById(oldBook).size() != 0)
	            		op.charge(book, id);
	            	else
	            		op.add(book);
	                // 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。  
	            } 
	        }); 
	    } 
	 
	    private void initPanel() 
	    { 
	        this.panel = new JPanel(); 
	    } 
	 
	 
	    /**
	     * 这里重写父类的编辑方法，返回一个JPanel对象即可（也可以直接返回一个Button对象，但是那样会填充满整个单元格）
	     */ 
	    @Override 
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
	    { 
	        // 只为按钮赋值即可。也可以作其它操作。  
	        this.button.setText("修改");
	        this.button.setFont(new Font("宋体", Font.PLAIN, 13));
	        return this.button; 
	    } 
	 
	    /**
	     * 重写编辑单元格时获取的值。如果不重写，这里可能会为按钮设置错误的值。
	     */ 
	    @Override 
	    public Object getCellEditorValue() 
	    { 
	        return this.button.getText(); 
	    } 
	}  
	/**
	 * Create the frame.
	 */
	public UltimateFrame() {
		setTitle("图书管理系统");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchTextField = new JTextField();
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER){
					DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
					tableModel.setRowCount(0);
					BookList booklist = new Operation().regexSearch(searchTextField.getText());
					for(int i = 0; i<booklist.size(); i++)
						tableModel.addRow(new Object[]{ booklist.get(i).id, booklist.get(i).bookname, booklist.get(i).author, booklist.get(i).price});
				}
			}
		});
		searchTextField.setForeground(Color.BLACK);
		searchTextField.setBackground(Color.WHITE);
		searchTextField.setBounds(10, 10, 458, 41);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 20));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
				tableModel.setRowCount(0);
				BookList booklist = new Operation().regexSearch(searchTextField.getText());
				for(int i = 0; i<booklist.size(); i++)
					tableModel.addRow(new Object[]{ booklist.get(i).id, booklist.get(i).bookname, booklist.get(i).author, booklist.get(i).price});
			}
		});
		searchButton.setForeground(Color.BLACK);
		searchButton.setBackground(Color.WHITE);
		searchButton.setBounds(478, 8, 93, 41);
		contentPane.add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 664, 390);
		contentPane.add(scrollPane);
		
		resultTable = new JTable();
		resultTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"编号", "书名", "作者", "单价", "", ""
			}
		));
		resultTable.getColumnModel().getColumn(5).setCellRenderer(new DeleteButtonRender());
		resultTable.getColumnModel().getColumn(5).setCellEditor(new DeleteButtonEditor());
		resultTable.getColumnModel().getColumn(4).setCellRenderer(new UpdateButtonRender());
		resultTable.getColumnModel().getColumn(4).setCellEditor(new UpdateButtonEditor());
		resultTable.setRowHeight(30);
		resultTable.setForeground(Color.BLACK);
		resultTable.setBackground(Color.WHITE);
		scrollPane.setViewportView(resultTable);
		
		button_1 = new JButton("新建");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
				tableModel.addRow(new Object[]{"", "", "",""});
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(581, 8, 93, 41);
		contentPane.add(button_1);
		
		
	}
}

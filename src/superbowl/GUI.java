package superbowl;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI extends JFrame implements ActionListener{

	private ArrayList<Superbowl> events;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel allPanel;
	private JPanel teamPanel;
	private JPanel searchPanel;
	private JPanel statsPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tm;
	private JLabel sortLabel;
	private JComboBox sortComboB;

	/**
	 * Create the frame.
	 */
	public GUI(ArrayList<Superbowl> events) {
		super("Superbowl");
		this.events = events;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 1430, 552);
		contentPane.add(tabbedPane);
		
		allPanel = new JPanel();
		tabbedPane.addTab("All", null, allPanel, null);
		allPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 43, 1397, 457);
		allPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Date", "Attendance", "Winner", "Winning Points", "Loser", "Losing Points", "MVP", "Stadium", "City", "State", "Point Difference"
				}
			);
		table.setModel(tm);
		drawTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		resizeColumnWidth(table);
		
		sortLabel = new JLabel("SORT BY:");
		sortLabel.setBounds(18, 15, 61, 16);
		allPanel.add(sortLabel);
		
		sortComboB = new JComboBox();
		sortComboB.setModel(new DefaultComboBoxModel(new String[] {"Attendance", "Winning Points", "Losing Points", "Stadium", "City", "State", "Point Difference"}));
		sortComboB.setBounds(77, 11, 151, 27);
		allPanel.add(sortComboB);
		
		teamPanel = new JPanel();
		tabbedPane.addTab("Teams", null, teamPanel, null);
		
		searchPanel = new JPanel();
		tabbedPane.addTab("Search", null, searchPanel, null);
		
		statsPanel = new JPanel();
		tabbedPane.addTab("Statistics", null, statsPanel, null);
	}
	
	public void drawTable()
	{
		tm.setRowCount(0);
		for (int i=0;i<events.size();i++)
		{
			Object[] object = new Object[11];
			object[0] = events.get(i).getDate();
			object[1] = events.get(i).getAttendance();
			object[2] = events.get(i).getWinner();
			object[3] = events.get(i).getWinningPoints();
			object[4] = events.get(i).getLoser();
			object[5] = events.get(i).getLosingPoints();
			object[6] = events.get(i).getMvp();
			object[7] = events.get(i).getStadium();
			object[8] = events.get(i).getCity();
			object[9] = events.get(i).getState();
			object[10] = events.get(i).getPointDifference();
			tm.addRow(object);
		}
		
	}
	
	public void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        width = Math.max(width, table.getColumnModel().getColumn(column).getPreferredWidth());
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

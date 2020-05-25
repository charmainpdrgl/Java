package superbowl;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI extends JFrame implements ActionListener{

	private ArrayList<Superbowl> events;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel allPanel;
	private JPanel historyPanel;
	private JPanel searchPanel;
	private JPanel statsPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tm;
	private JLabel sortLabel;
	private String[] sortOptions = {"Attendance", "Winning Points", "Losing Points", "Stadium", "City", "State", "Point Difference"};
	private JComboBox sortComboB;
	private JLabel dateLabel;
	private JTextField dateText;
	private JLabel attendanceLabel;
	private JTextField attendanceText;
	private JLabel locationLabel;
	private JTextField locationText;
	private JLabel winningTeamLabel;
	private JLabel losingTeamLabel;
	private JLabel winnerPhotoLabel;
	private JPanel winnerPanel;
	private JLabel wNameLabel;
	private JLabel wPointsLabel;
	private JLabel wMVPLabel;
	private JPanel loserPanel;
	private JLabel loserPhotoLabel;
	private JLabel lNameLabel;
	private JLabel lPointsLabel;
	private JTextField wNameText;
	private JTextField wPointText;
	private JTextField wMVPText;
	private JTextField lNameText;
	private JTextField lPointText;
	private JButton previousButton;
	private JButton nextButton;
	private int counter = 0;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GUI(ArrayList<Superbowl> events) {
		super("Superbowl");
		this.events = events;
		
		Object[] object = new Object[11];
		for (int i=0;i<counter;i++)
		{
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
		}
		
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
		sortComboB.setName("");
		sortComboB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dropDownValue = sortComboB.getSelectedItem().toString();
				switch(dropDownValue)
				{
					case "Attendance":
						Collections.sort(events, new AttendanceCompare());
						drawTable();
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						resizeColumnWidth(table);
						revalidate();
						break;
					case "Winning Points":
						Collections.sort(events, new WinningPointsCompare());
						drawTable();
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						resizeColumnWidth(table);
						revalidate();
						break;
					case "Losing Points":
						Collections.sort(events, new LosingPointsCompare());
						drawTable();
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						resizeColumnWidth(table);
						revalidate();
						break;
					case "Stadium":
						Collections.sort(events, new StadiumCompare());
						drawTable();
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						resizeColumnWidth(table);
						revalidate();
						break;
					case "City":
						Collections.sort(events, new CityCompare());
						drawTable();
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						resizeColumnWidth(table);
						revalidate();
						break;
					case "State":
						Collections.sort(events, new StateCompare());
						drawTable();
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						resizeColumnWidth(table);
						revalidate();
						break;
					case "Point Difference":
						Collections.sort(events, new PointDifferenceCompare());
						drawTable();
						table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						resizeColumnWidth(table);
						revalidate();
						break;
				}
			}
		});
		sortComboB.setModel(new DefaultComboBoxModel(sortOptions));
		sortComboB.setBounds(77, 11, 151, 27);
		allPanel.add(sortComboB);
		
		historyPanel = new JPanel();
		tabbedPane.addTab("Event History", null, historyPanel, null);
		historyPanel.setLayout(null);
		
		dateLabel = new JLabel("Date:");
		dateLabel.setBounds(277, 17, 61, 16);
		historyPanel.add(dateLabel);
		
		dateText = new JTextField();
		dateText.setEditable(false);
		dateText.setBounds(316, 12, 105, 26);
		historyPanel.add(dateText);
		dateText.setColumns(10);
		dateText.setText(events.get(0).getDate().toString());
		
		attendanceLabel = new JLabel("Attendance:");
		attendanceLabel.setBounds(568, 17, 91, 16);
		historyPanel.add(attendanceLabel);
		
		attendanceText = new JTextField();
		attendanceText.setEditable(false);
		attendanceText.setBounds(647, 12, 98, 26);
		historyPanel.add(attendanceText);
		attendanceText.setColumns(10);
		attendanceText.setText(Integer.toString(events.get(0).getAttendance()));
		
		locationLabel = new JLabel("Location:");
		locationLabel.setBounds(915, 17, 61, 16);
		historyPanel.add(locationLabel);
		
		locationText = new JTextField();
		locationText.setEditable(false);
		locationText.setBounds(981, 12, 377, 26);
		historyPanel.add(locationText);
		locationText.setColumns(10);
		locationText.setText(events.get(0).getStadium() + ", " + events.get(0).getCity() + ", " + events.get(0).getState());
		
		winningTeamLabel = new JLabel("Winning Team");
		winningTeamLabel.setBounds(420, 89, 135, 16);
		historyPanel.add(winningTeamLabel);
		
		losingTeamLabel = new JLabel("Losing Team");
		losingTeamLabel.setBounds(910, 89, 121, 16);
		historyPanel.add(losingTeamLabel);
		
		winnerPanel = new JPanel();
		winnerPanel.setBounds(45, 89, 315, 273);
		historyPanel.add(winnerPanel);
		
		winnerPhotoLabel = new JLabel("winner");
		winnerPanel.add(winnerPhotoLabel);
		
		wNameLabel = new JLabel("Name:");
		wNameLabel.setBounds(420, 155, 61, 16);
		historyPanel.add(wNameLabel);
		
		wPointsLabel = new JLabel("Points:");
		wPointsLabel.setBounds(420, 256, 61, 16);
		historyPanel.add(wPointsLabel);
		
		wMVPLabel = new JLabel("MVP:");
		wMVPLabel.setBounds(420, 346, 61, 16);
		historyPanel.add(wMVPLabel);
		
		loserPanel = new JPanel();
		loserPanel.setBounds(1043, 89, 315, 273);
		historyPanel.add(loserPanel);
		
		loserPhotoLabel = new JLabel("loser");
		loserPanel.add(loserPhotoLabel);
		
		lNameLabel = new JLabel("Name:");
		lNameLabel.setBounds(782, 155, 61, 16);
		historyPanel.add(lNameLabel);
		
		lPointsLabel = new JLabel("Points:");
		lPointsLabel.setBounds(782, 256, 61, 16);
		historyPanel.add(lPointsLabel);
		
		wNameText = new JTextField();
		wNameText.setEditable(false);
		wNameText.setBounds(485, 150, 174, 26);
		historyPanel.add(wNameText);
		wNameText.setColumns(10);
		wNameText.setText(events.get(0).getWinner());
		
		wPointText = new JTextField();
		wPointText.setEditable(false);
		wPointText.setBounds(485, 251, 130, 26);
		historyPanel.add(wPointText);
		wPointText.setColumns(10);
		wPointText.setText(Integer.toString(events.get(0).getWinningPoints()));
		
		wMVPText = new JTextField();
		wMVPText.setEditable(false);
		wMVPText.setBounds(485, 341, 130, 26);
		historyPanel.add(wMVPText);
		wMVPText.setColumns(10);
		wMVPText.setText(events.get(0).getMvp());
		
		lNameText = new JTextField();
		lNameText.setEditable(false);
		lNameText.setBounds(855, 150, 176, 26);
		historyPanel.add(lNameText);
		lNameText.setColumns(10);
		lNameText.setText(events.get(0).getLoser());
		
		lPointText = new JTextField();
		lPointText.setEditable(false);
		lPointText.setBounds(855, 251, 130, 26);
		historyPanel.add(lPointText);
		lPointText.setColumns(10);
		lPointText.setText(Integer.toString(events.get(0).getLosingPoints()));
		counter++;
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] object = new Object[11];
				for (int i=0;i<counter-1;i++)
				{
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
					dateText.setText(object[0].toString());
					attendanceText.setText(object[1].toString());
					wNameText.setText(object[2].toString());
					wPointText.setText(object[3].toString());
					lNameText.setText(object[4].toString());
					lPointText.setText(object[5].toString());
					wMVPText.setText(object[6].toString());
					locationText.setText(object[7].toString() + ", " + object[8].toString() + ", " + object[9].toString());
				}
				counter--;
				
				if (counter == 0)
				{
					counter = events.size()+1;
				}
			}
		});
		previousButton.setBounds(568, 437, 117, 29);
		historyPanel.add(previousButton);
		
		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] object = new Object[11];
				for (int i=0;i<counter+1;i++)
				{
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
					dateText.setText(object[0].toString());
					attendanceText.setText(object[1].toString());
					wNameText.setText(object[2].toString());
					wPointText.setText(object[3].toString());
					lNameText.setText(object[4].toString());
					lPointText.setText(object[5].toString());
					wMVPText.setText(object[6].toString());
					locationText.setText(object[7].toString() + ", " + object[8].toString() + ", " + object[9].toString());
				}
				counter++;
				
				if (counter == events.size())
				{
					counter = 0+1;
				}
				
			}
		});
		nextButton.setBounds(697, 437, 117, 29);
		historyPanel.add(nextButton);
		
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

package superbowl;

import java.awt.Component;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.util.*;
import javax.swing.border.TitledBorder;

public class GUI extends JFrame implements ActionListener{

	private ArrayList<Superbowl> events;
	
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel allPanel;
	private JPanel teamsPanel;
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
	private JLabel mvpLabel;
	private JPanel loserPanel;
	private JLabel loserPhotoLabel;
	private JLabel nameLabel;
	private JLabel pointsLabel;
	private JTextField wNameText;
	private JTextField wPointText;
	private JTextField wMVPText;
	private JTextField lNameText;
	private JTextField lPointText;
	private JButton previousButton;
	private JButton nextButton;
	private int counter = 0;
	private JLabel searchLabel;
	private JTextField searchText;
	private JButton showResultsButton;
	private JDialog results;
	private JFrame resultFrame;
	private JButton b;
	private int max;
	private JPanel panel;
	private JLabel totalLabel;
	private JLabel minAttendanceLabel;
	private JLabel maxAttendanceLabel;
	private JLabel minScoreLabel;
	private JLabel maxScoreLabel;
	private JLabel averageLabel;
	private JTextField totalGamesText;
	private JTextField minAttendanceText;
	private JTextField maxAttendanceText;
	private JTextField minScoreText;
	private JTextField maxScoreText;
	private JTextField averageText;
	private JButton statsButton;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		scrollPane.setBounds(6, 80, 1397, 420);
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
		sortLabel.setBounds(385, 31, 61, 16);
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
		sortComboB.setBounds(444, 27, 151, 27);
		allPanel.add(sortComboB);
		
		searchLabel = new JLabel("SEARCH:");
		searchLabel.setBounds(812, 31, 61, 16);
		allPanel.add(searchLabel);
		
		searchText = new JTextField();
		searchText.setForeground(Color.LIGHT_GRAY);
		searchText.setText(" type team name here...");
		searchText.setBounds(872, 26, 203, 26);
		allPanel.add(searchText);
		searchText.setColumns(10);
		
		showResultsButton = new JButton("Show Results");
		showResultsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				int winnerCounter = 0;
				
				for(int j = 0; j<events.size();j++)
				{
					
					if(events.get(j).getWinner().equalsIgnoreCase(searchText.getText()))
						{
							winnerCounter++;
						}
				}
				
				
				

			}
		});
		showResultsButton.setBounds(1111, 26, 117, 29);
		allPanel.add(showResultsButton);
		
		teamsPanel = new JPanel();
		tabbedPane.addTab("Teams", null, teamsPanel, null);
		teamsPanel.setLayout(null);
		
		dateLabel = new JLabel("Date:");
		dateLabel.setBounds(277, 17, 61, 16);
		teamsPanel.add(dateLabel);
		
		dateText = new JTextField();
		dateText.setEditable(false);
		dateText.setBounds(316, 12, 105, 26);
		teamsPanel.add(dateText);
		dateText.setColumns(10);
		dateText.setText(events.get(0).getDate().toString());
		
		attendanceLabel = new JLabel("Attendance:");
		attendanceLabel.setBounds(568, 17, 91, 16);
		teamsPanel.add(attendanceLabel);
		
		attendanceText = new JTextField();
		attendanceText.setEditable(false);
		attendanceText.setBounds(647, 12, 98, 26);
		teamsPanel.add(attendanceText);
		attendanceText.setColumns(10);
		attendanceText.setText(Integer.toString(events.get(0).getAttendance()));
		
		locationLabel = new JLabel("Location:");
		locationLabel.setBounds(915, 17, 61, 16);
		teamsPanel.add(locationLabel);
		
		locationText = new JTextField();
		locationText.setEditable(false);
		locationText.setBounds(981, 12, 377, 26);
		teamsPanel.add(locationText);
		locationText.setColumns(10);
		locationText.setText(events.get(0).getStadium() + ", " + events.get(0).getCity() + ", " + events.get(0).getState());
		
		winningTeamLabel = new JLabel("Winning Team");
		winningTeamLabel.setBounds(420, 89, 135, 16);
		teamsPanel.add(winningTeamLabel);
		
		losingTeamLabel = new JLabel("Losing Team");
		losingTeamLabel.setBounds(910, 89, 121, 16);
		teamsPanel.add(losingTeamLabel);
		
		winnerPanel = new JPanel();
		winnerPanel.setBounds(45, 89, 315, 273);
		teamsPanel.add(winnerPanel);
		
		winnerPhotoLabel = new JLabel("winner");
		winnerPanel.add(winnerPhotoLabel);
		
		mvpLabel = new JLabel("MVP");
		mvpLabel.setBounds(673, 192, 61, 16);
		teamsPanel.add(mvpLabel);
		
		loserPanel = new JPanel();
		loserPanel.setBounds(1043, 89, 315, 273);
		teamsPanel.add(loserPanel);
		
		loserPhotoLabel = new JLabel("loser");
		loserPanel.add(loserPhotoLabel);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(673, 122, 61, 16);
		teamsPanel.add(nameLabel);
		
		pointsLabel = new JLabel("Points");
		pointsLabel.setBounds(673, 159, 61, 16);
		teamsPanel.add(pointsLabel);
		
		wNameText = new JTextField();
		wNameText.setEditable(false);
		wNameText.setBounds(485, 117, 174, 26);
		teamsPanel.add(wNameText);
		wNameText.setColumns(10);
		wNameText.setText(events.get(0).getWinner());
		
		wPointText = new JTextField();
		wPointText.setEditable(false);
		wPointText.setBounds(529, 154, 130, 26);
		teamsPanel.add(wPointText);
		wPointText.setColumns(10);
		wPointText.setText(Integer.toString(events.get(0).getWinningPoints()));
		
		wMVPText = new JTextField();
		wMVPText.setEditable(false);
		wMVPText.setBounds(529, 187, 130, 26);
		teamsPanel.add(wMVPText);
		wMVPText.setColumns(10);
		wMVPText.setText(events.get(0).getMvp());
		
		lNameText = new JTextField();
		lNameText.setEditable(false);
		lNameText.setBounds(724, 117, 176, 26);
		teamsPanel.add(lNameText);
		lNameText.setColumns(10);
		lNameText.setText(events.get(0).getLoser());
		
		lPointText = new JTextField();
		lPointText.setEditable(false);
		lPointText.setBounds(724, 154, 130, 26);
		teamsPanel.add(lPointText);
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
		previousButton.setBounds(568, 471, 117, 29);
		teamsPanel.add(previousButton);
		
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
		nextButton.setBounds(697, 471, 117, 29);
		teamsPanel.add(nextButton);
		
		statsPanel = new JPanel();
		tabbedPane.addTab("Statistics", null, statsPanel, null);
		statsPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(105, 60, 466, 413);
		statsPanel.add(panel);
		panel.setLayout(null);
		
		totalLabel = new JLabel("Total Games");
		totalLabel.setBounds(63, 39, 87, 16);
		panel.add(totalLabel);
		
		minAttendanceLabel = new JLabel("Minimum Attendance");
		minAttendanceLabel.setBounds(63, 109, 139, 16);
		panel.add(minAttendanceLabel);
		
		maxAttendanceLabel = new JLabel("Maximum Attendance");
		maxAttendanceLabel.setBounds(63, 151, 139, 16);
		panel.add(maxAttendanceLabel);
		
		minScoreLabel = new JLabel("Minimum Game Score");
		minScoreLabel.setBounds(63, 230, 139, 16);
		panel.add(minScoreLabel);
		
		maxScoreLabel = new JLabel("Maximum Game Score");
		maxScoreLabel.setBounds(63, 272, 139, 16);
		panel.add(maxScoreLabel);
		
		averageLabel = new JLabel("Average Point Difference");
		averageLabel.setBounds(63, 357, 172, 16);
		panel.add(averageLabel);
		
		totalGamesText = new JTextField();
		totalGamesText.setEditable(false);
		totalGamesText.setBounds(275, 34, 130, 26);
		panel.add(totalGamesText);
		totalGamesText.setColumns(10);
		
		minAttendanceText = new JTextField();
		minAttendanceText.setEditable(false);
		minAttendanceText.setBounds(275, 104, 130, 26);
		panel.add(minAttendanceText);
		minAttendanceText.setColumns(10);
		
		maxAttendanceText = new JTextField();
		maxAttendanceText.setEditable(false);
		maxAttendanceText.setBounds(275, 146, 130, 26);
		panel.add(maxAttendanceText);
		maxAttendanceText.setColumns(10);
		
		minScoreText = new JTextField();
		minScoreText.setEditable(false);
		minScoreText.setBounds(275, 225, 130, 26);
		panel.add(minScoreText);
		minScoreText.setColumns(10);
		
		maxScoreText = new JTextField();
		maxScoreText.setEditable(false);
		maxScoreText.setBounds(275, 267, 130, 26);
		panel.add(maxScoreText);
		maxScoreText.setColumns(10);
		
		averageText = new JTextField();
		averageText.setEditable(false);
		averageText.setBounds(275, 352, 130, 26);
		panel.add(averageText);
		averageText.setColumns(10);
		
		statsButton = new JButton("Generate Statistics");
		statsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalGamesText.setText(Integer.toString(events.size()));
				minAttendanceText.setText(Integer.toString(Utilities.findMinimumAttendance(events)));
				maxAttendanceText.setText(Integer.toString(Utilities.findMaximumAttendance(events)));
				minScoreText.setText(Integer.toString(Utilities.findLowestScore(events)));
				maxScoreText.setText(Integer.toString(Utilities.findHighestScore(events)));
				averageText.setText(Integer.toString(Utilities.findAveragePointDif(events)));
			}
		});
		statsButton.setBounds(250, 19, 167, 29);
		statsPanel.add(statsButton);
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

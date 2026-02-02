package findmytrain;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class FindMyTrainApp extends JFrame {

	private TrainSystem system;
	private JTextField sourceField, destinationField, trainNumberField, stationField;
	private JTextArea outputArea;

	public FindMyTrainApp() {

		system = createTrainSystem();

		setTitle("Find My Train 🚆");
		setSize(750, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// 🔹 TOP PANEL
		JLabel title = new JLabel("Find My Train System", JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 22));
		add(title, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel(new GridLayout(5, 2, 10, 10));

		centerPanel.add(new JLabel("Source Station:"));
		sourceField = new JTextField();
		centerPanel.add(sourceField);

		centerPanel.add(new JLabel("Destination Station:"));
		destinationField = new JTextField();
		centerPanel.add(destinationField);

		centerPanel.add(new JLabel("Train Number:"));
		trainNumberField = new JTextField();
		centerPanel.add(trainNumberField);

		centerPanel.add(new JLabel("Station Name:"));
		stationField = new JTextField();
		centerPanel.add(stationField);

		add(centerPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));

		JButton searchBtn = new JButton("Search Train");
		JButton scheduleBtn = new JButton("View Schedule");
		JButton stationBtn = new JButton("Station-wise Trains");
		JButton clearBtn = new JButton("Clear");

		buttonPanel.add(searchBtn);
		buttonPanel.add(scheduleBtn);
		buttonPanel.add(stationBtn);
		buttonPanel.add(clearBtn);

		add(buttonPanel, BorderLayout.SOUTH);

		outputArea = new JTextArea();
		outputArea.setEditable(false);
		outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		add(new JScrollPane(outputArea), BorderLayout.EAST);

		searchBtn.addActionListener(e -> searchTrain());
		scheduleBtn.addActionListener(e -> showSchedule());
		stationBtn.addActionListener(e -> stationWiseTrains());
		clearBtn.addActionListener(e -> outputArea.setText(""));
	}

	private void searchTrain() {
		outputArea.setText("");

		String src = sourceField.getText().trim();
		String dest = destinationField.getText().trim();

		if (src.isEmpty() || dest.isEmpty()) {
			outputArea.setText("Please enter source and destination.");
			return;
		}

		system.searchTrain(src, dest, outputArea);
	}

	private void showSchedule() {
		outputArea.setText("");

		try {
			int trainNo = Integer.parseInt(trainNumberField.getText().trim());
			system.showSchedule(trainNo, outputArea);
		} catch (NumberFormatException e) {
			outputArea.setText("Invalid Train Number.");
		}
	}

	private void stationWiseTrains() {
		outputArea.setText("");

		String station = stationField.getText().trim();

		if (station.isEmpty()) {
			outputArea.setText("Enter station name.");
			return;
		}

		system.stationTrains(station, outputArea);
	}

	private TrainSystem createTrainSystem() {

		TrainSystem ts = new TrainSystem();

		Station pune = new Station("Pune");
		Station nashik = new Station("Nashik");
		Station mumbai = new Station("Mumbai");

		List<Schedule> sch = Arrays.asList(new Schedule(pune, "08:00", "08:10"), new Schedule(nashik, "10:30", "10:35"),
				new Schedule(mumbai, "13:00", "--"));

		Train t1 = new Train(11001, "Deccan Express", sch);
		ts.addTrain(t1);

		return ts;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new FindMyTrainApp().setVisible(true);
		});
	}
}

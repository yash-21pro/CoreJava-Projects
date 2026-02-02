package findmytrain;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class TrainSystem {

    private List<Train> trains = new ArrayList<>();

    public void addTrain(Train train) {
        trains.add(train);
    }

    
    
    public void searchTrain(String source, String destination, JTextArea area) {
        boolean found = false;

        for (Train train : trains) {
            List<Schedule> sch = train.getSchedules();
            int srcIndex = -1, destIndex = -1;

            for (int i = 0; i < sch.size(); i++) {
                if (sch.get(i).getStation().getName().equalsIgnoreCase(source))
                    srcIndex = i;
                if (sch.get(i).getStation().getName().equalsIgnoreCase(destination))
                    destIndex = i;
            }

            if (srcIndex != -1 && destIndex != -1 && srcIndex < destIndex) {
                area.append(train.getTrainNumber() + " - "
                        + train.getTrainName()
                        + " | Status: " + train.getStatus() + "\n");
                found = true;
            }
        }

        if (!found) {
            area.append("No train found between given stations.\n");
        }
    }

    
    
    
    public void showSchedule(int trainNumber, JTextArea area) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                area.append("Schedule of " + train.getTrainName() + "\n");
                for (Schedule s : train.getSchedules()) {
                    area.append(
                        s.getStation().getName() + " | "
                        + s.getArrivalTime() + " - "
                        + s.getDepartureTime() + "\n"
                    );
                }
                return;
            }
        }
        area.append("Train not found.\n");
    }



    
    
    public void stationTrains(String stationName, JTextArea area) {
        boolean found = false;
        area.append("Trains passing through " + stationName + ":\n");

        for (Train train : trains) {
            for (Schedule s : train.getSchedules()) {
                if (s.getStation().getName().equalsIgnoreCase(stationName)) {
                    area.append(train.getTrainNumber() + " - "
                            + train.getTrainName() + "\n");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            area.append("No trains found.\n");
        }
    }
}

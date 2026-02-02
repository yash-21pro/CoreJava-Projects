package findmytrain;

import java.util.List;

public class Train {
    private int trainNumber;
    private String trainName;
    private List<Schedule> schedules;
    private TrainStatus status;

    public Train(int trainNumber, String trainName, List<Schedule> schedules) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.schedules = schedules;
        this.status = TrainStatus.ON_TIME;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public TrainStatus getStatus() {
        return status;
    }

    public void setStatus(TrainStatus status) {
        this.status = status;
    }
}

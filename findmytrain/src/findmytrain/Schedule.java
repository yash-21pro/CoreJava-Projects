package findmytrain;

public class Schedule {
    private Station station;
    private String arrivalTime;
    private String departureTime;

    public Schedule(Station station, String arrivalTime, String departureTime) {
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Station getStation() {
        return station;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }
}

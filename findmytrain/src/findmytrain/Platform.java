package findmytrain;

public class Platform {
    private int platformNumber;
    private boolean available = true;

    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignTrain() {
        available = false;
    }

    public void releasePlatform() {
        available = true;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }
}


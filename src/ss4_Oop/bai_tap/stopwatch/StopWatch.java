package ss4_Oop.bai_tap.stopwatch;

public class StopWatch {
    private double startTime;
    private double endTime;

    public StopWatch(double startTime, double endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

}

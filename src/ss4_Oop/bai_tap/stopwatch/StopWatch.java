package ss4_Oop.bai_tap.stopwatch;

import java.time.Instant;

public class StopWatch {
    private double startTime;
    private double endTime;
    public StopWatch(){
        startTime= Instant.now().toEpochMilli();//Chuyển thời gian hiện tại thành số milliseconds
    }
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
    //cap nhat thoi gian
    public void start(){
        startTime=Instant.now().toEpochMilli();
    }
    public void end(){
        endTime=Instant.now().toEpochMilli();
    }
    public double getElapsedTime() {
        return endTime-startTime;
    }

}

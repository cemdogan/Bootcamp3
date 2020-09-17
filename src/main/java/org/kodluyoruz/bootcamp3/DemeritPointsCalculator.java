package org.kodluyoruz.bootcamp3;

public class DemeritPointsCalculator {

    protected static final int MAX_SPEED = 300;
    protected static final int SPEED_LIMIT = 65;

    public int calculateDemeritPoints(int speed) {

        if(speed < 0 || speed > MAX_SPEED){
            throw new IllegalArgumentException();
        }

        if(speed <= SPEED_LIMIT){
            return 0;
        }

        int speedRemainder = speed % 5;
        speed = speed - speedRemainder;
        int result = (speed - SPEED_LIMIT) / 5;
        if(speedRemainder > 0){
            result++;
        }
        return result;
    }
}

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MonteCarlo extends Thread{
    private int R=1;
    private int x0=0;
    private int y0=0;

    List<DoublePoint> pointsIn = new ArrayList<>();
    List<DoublePoint> pointsOut = new ArrayList<>();

    int pointsAmount = 10000;

    double squareArea = Math.pow(2*R,2);


    public MonteCarlo() {

    }

    private double calculate(){
        for(int i=0; i<=pointsAmount; i++){
            double tempPointX = generateRandomDouble(-1,1);
            double tempPointY = generateRandomDouble(-1,1);
            var tempPoint = new DoublePoint(tempPointX,tempPointY);

            if(Math.pow(tempPointX,2) + Math.pow(tempPointY,2) <= Math.pow(R,2)){
                pointsIn.add(tempPoint);

            }
            else {
                pointsOut.add(tempPoint);

            }
        }
        return squareArea * pointsIn.size() / pointsAmount;
    }

    private double generateRandomDouble(int rangeMin, int rangeMax){
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

    @Override
    public void run() {
        System.out.println("Pole okręgu: " + calculate());
    }
}

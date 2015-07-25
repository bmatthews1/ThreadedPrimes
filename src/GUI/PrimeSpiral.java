package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class PrimeSpiral extends JFrame { // implements Runnable{

    public final int FRAME_WIDTH = 800;
    public final int FRAME_HEIGHT = 800;
    public final int NUM_ITERATIONS = 400;
    public final int NUM_DIRECTIONS = 4;
    //public final int SOME_NUMBER = 5;
    private int[] xDir = {1, 0, -1, 0};
    private int[] yDir = {0, 1, 0, -1};
    private Point startTile = new Point((int)(FRAME_WIDTH/2), (int)(FRAME_HEIGHT/2));
    private Point curTile;
    LinkedList<Point> tilesToVisit = new LinkedList<Point>();

    public PrimeSpiral() {

        tilesToVisit.addFirst(curTile);
        curTile = new Point();
        curTile.setLocation(startTile.getX(),startTile.getY());
        setTitle("PrimeSpiral");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setVisible(true);

    }

    private void run(){

        while(true){
            repaint();
        }

    }
    @Override
    public void paint(Graphics g){

            paintPrimes(g);

    }

    private void updateCoordinates(int curDir){

        int dx = xDir[curDir];
        int dy = yDir[curDir];
        int curX = (int)curTile.getX();
        int curY = (int)curTile.getY();
        curTile.setLocation(curX+dx, curY+dy);

    }

    private boolean isItPrime(int number){

        double numberToDouble = (double) number;
        int sqrt = (int) Math.ceil(Math.sqrt(numberToDouble));
        for(int i = 2; i <= sqrt; i++){
          if(number % i == 0 && number != 2 || number == 1) return false;
        }
        return true;
    }

    private void paintPrimes (Graphics g){

        int totalNum = 1;
        for(int numLayers = 1; numLayers < NUM_ITERATIONS; numLayers++) {
            curTile.setLocation(curTile.getX() - numLayers, curTile.getY() - numLayers);
            for (int curDir = 0; curDir < NUM_DIRECTIONS; curDir++) {
                for (int dist = 0; dist < 2 * numLayers; dist++) {
                    updateCoordinates(curDir);
                    if (isItPrime(totalNum)) {
                        g.setColor(Color.white);
                        g.drawLine((int) curTile.getX(), (int) curTile.getY(),
                                   (int) curTile.getX(), (int) curTile.getY());
                    }
                    else {
                        g.setColor(Color.black);
                        g.drawLine((int) curTile.getX(), (int) curTile.getY(),
                                   (int) curTile.getX(), (int) curTile.getY());
                    }
                    totalNum++;
                }
            }
            curTile.setLocation(startTile.getX(),startTile.getY());
        }

    }

    public static void main(String[] args){

        PrimeSpiral primeSpiral = new PrimeSpiral();
        primeSpiral.run();

    }
}

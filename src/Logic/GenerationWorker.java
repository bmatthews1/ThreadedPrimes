package Logic;


import java.util.ArrayList;

/**
 * Created by arirappaport on 7/17/15.
 */
public class GenerationWorker implements Runnable{

    private String task;
    private double sqrt;
    private static boolean[] foundFactor = new boolean[2];


    public GenerationWorker(String task, Long number){
        this.task = task;
        double numberToDouble = number.doubleValue();
        this.sqrt = Math.ceil(Math.sqrt(numberToDouble));
        foundFactor[0] = false;
        foundFactor[1] = false;

    }
    public static void main(String[] args){
        GenerationWorker upper = new GenerationWorker("upper", Long.parseLong(args[0]));
        GenerationWorker lower = new GenerationWorker("lower", Long.parseLong(args[0]));
        Thread t1 = new Thread(upper);
        Thread t2 = new Thread(lower);
        t1.start();
        t2.start();
    }

    @Override
    public void run(){
        if((this.task).equals("upper")){
            checkUpper(sqrt);
        }
        if((this.task).equals("lower")){
            checkLower(sqrt);
        }
    }

    private void checkUpper(double number){
        
    }
    private void checkLower(double number){}


}

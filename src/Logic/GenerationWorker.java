package Logic;

//import java.util.ArrayList;
//import java.util.concurrent.BlockingQueue;
//
//import GUI.*;
//
///*
//   Ari Rappaport
//   Student at UNM
//
//   Multithreaded Class that should run in parallel to reduce time
//   needed to generate large primes
// */
public class GenerationWorker{ //implements Runnable{
//
//    private long upperBound;
//    private long number;
//    private ArrayList<Long> primes;
//    private BlockingQueue<Long> sharedPrimes = new BlockingQueue<Long>() {
//    };
//    private long sqrt;
//
//    public GenerationWorker(Long number){
//        this.upperBound = number;
//        double numberToDouble = number.doubleValue();
//        this.sqrt = (long) Math.ceil(Math.sqrt(numberToDouble));
//    }
//
//    public static void main(String[] args){
//        GenerationWorker generator = new GenerationWorker(Long.parseLong(args[0]));
//        PrimeSpiral gui = new PrimeSpiral();
//        Thread t1 = new Thread(generator);
//        Thread t2 = new Thread(gui);
//        t1.start();
//        t2.start();
//    }
//
//    @Override
//    public void run(){
//        for(long i = 2; i <= upperBound; i++){
//            findNextPrime(upperBound);
//        }
//    }
//
//    private void findNextPrime(long upperBound){
//
//
//
//    }
//
}

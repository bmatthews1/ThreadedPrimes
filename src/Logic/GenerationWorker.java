package Logic;

/*
   Ari Rappaport
   Student at UNM

   Multithreaded Class that should run in parallel to reduce time
   needed to generate large primes
 */
public class GenerationWorker implements Runnable{

    private String task;
    private long number;
    private long sqrt;
    private long halfSqrt;
    private static boolean[] foundFactor = new boolean[2];


    public GenerationWorker(String task, Long number){
        this.task = task;
        this.number = number;
        double numberToDouble = number.doubleValue();
        this.sqrt = (long) Math.ceil(Math.sqrt(numberToDouble));
        this.halfSqrt = (long) Math.ceil((double) (sqrt/2));
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
        if(!foundFactor[0] && !foundFactor[1]){
            System.out.println("It's a prime alright!");
        }
        else{
            System.out.println("Not a prime, I'm afraid.");
        }
    }

    @Override
    public void run(){
        if((this.task).equals("upper")){
            checkUpper(halfSqrt, sqrt);
        }
        if((this.task).equals("lower")){
            checkLower(halfSqrt);
        }
    }

    private void checkLower(long halfSqrt){

        for(long i = 2; i < halfSqrt; i++){

            if(number % i == 0){
                foundFactor[0] = true;
                return;
            }
        }
    }

    private void checkUpper(long halfSqrt, long sqrt){

        for(long i = halfSqrt; i < sqrt; i++){

            if(number % i == 0){
                foundFactor[1] = true;
                return;
            }
        }
    }

}

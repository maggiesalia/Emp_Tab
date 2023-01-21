public class Main {

    public static void main(String[] args){

        MyRunnableThread myRunnableThread = new MyRunnableThread();
        Thread thread  = new Thread(myRunnableThread);
        thread.start();
        System.out.println("Main Class");

        for(int i=0; i<20; i++){
            Thread thread1 = new Thread(new MyRunnableThread());
            thread1.start();
        }

    }
}
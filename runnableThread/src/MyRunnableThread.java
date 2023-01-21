public class MyRunnableThread implements Runnable{

    @Override
    public void run() {
//        System.out.println("Current thread id: " + Thread.currentThread().getId());

        for(int i=0; i<20; i++){
            System.out.println("Current thread id: " + Thread.currentThread().getId());
        }
    }

}

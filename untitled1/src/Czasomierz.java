public class Czasomierz extends Thread{
    int miliseconds;

    private void display() throws InterruptedException {
        while (true){
            sleep(1000);
            miliseconds+=1000;
            long minutes = (miliseconds / 1000) / 60;
            long seconds = (miliseconds / 1000) % 60;
            System.out.println(minutes +":"+seconds);
        }
    }

    @Override
    public void run() {
        try {
            display();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

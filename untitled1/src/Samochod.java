public class Samochod extends Thread{

    private String nrRej;
    private int pojZbiornika;
    private int paliwo;
    private boolean jazda = true;

    public Samochod (String nr, int pojZbiornika){
        this.nrRej = nr;
        this.pojZbiornika = pojZbiornika;
    }

    public void tankowanie (int paliwo){
        if(this.paliwo + paliwo < pojZbiornika){
            this.paliwo += paliwo;
        }
        else {
            System.out.println("Przekroczono pojemnosc");
        }

    }

    @Override
    public void run() {
        while(jazda){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(nrRej + " | paliwo: " + paliwo);
            paliwo--;
        }
    }

    @Override
    public synchronized void start() {
        jazda = true;
        run();
    }



    //public void start() //start samochodu, uruchamiamy wątek zużycia paliwa
  //  public void stop() zatrzymanie samochodu, zatrzymujemy wątek zużycia paliwa
    //public void run() //kod, który wykonuje się w odrębnym wątku, co 1 s programu zużywany jest 1 litr paliwa
}

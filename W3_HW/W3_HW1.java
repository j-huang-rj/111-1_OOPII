import java.util.Random;

class HSRPOS implements Runnable {

    private static int seatTotal = 10000;
    private final int LIMIT = 4;
    private String sysName;
    private int seatSold = 0;
    private int seatSoldTotal = 0;

    public HSRPOS(String sysName) {
        this.sysName = sysName;
    }

    private synchronized static boolean sellTicket(int seatSold) {
        if ((HSRPOS.seatTotal - seatSold) > 0) {
            HSRPOS.seatTotal -= seatSold;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (this.seatSold == 0) {
            this.seatSold = rand.nextInt(LIMIT + 1);
        }
        boolean available = sellTicket(this.seatSold);
        while (available) {
            this.seatSoldTotal += this.seatSold;
            System.out.println("-------- " + this.sysName + " --------\n" + "Seat sold: " + this.seatSold + "\n"
                    + "Seat sold total: " + this.seatSoldTotal + "\n" + "Seat available: " + HSRPOS.seatTotal + "\n"
                    + "-------- " + this.sysName
                    + " --------\n\n");
            while (this.seatSold == 0) {
                this.seatSold = rand.nextInt(LIMIT + 1);
            }
            available = sellTicket(this.seatSold);
        }
        System.out.println("-------- " + this.sysName + " --------\n" + "Seat has been occupied!" + "\n"
                + "Seat sold total: " + this.seatSoldTotal + "\n" + "Seat available: " + HSRPOS.seatTotal + "\n"
                + "-------- "
                + this.sysName
                + " --------\n\n");
    }
}

public class W3_HW1 {
    public static void main(String[] args) {
        Thread sys1 = new Thread(new HSRPOS("HSR_POS No.1"));
        Thread sys2 = new Thread(new HSRPOS("HSR_POS No.2"));
        Thread sys3 = new Thread(new HSRPOS("HSR_POS No.3"));
        Thread sys4 = new Thread(new HSRPOS("HSR_POS No.4"));
        sys1.start();
        sys2.start();
        sys3.start();
        sys4.start();
    }
}

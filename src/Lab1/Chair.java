package Lab1;

import Lab1.enumeration.ChairLegs;
import Lab1.exception.BrokenChair;

public class Chair extends Furniture{

    private class Backboard implements ShowDimensions {
        float height;
        float width;

        Backboard(float w, float h) {
            height = h;
            width = w;
        }

        Backboard() {
            height = width = (float) 10;
        }

        public void show() {
            System.out.println("Class backboard:\nWidth: " + width + ".\nHeight: " + height + ".\n");
        }
    }

    Backboard back;
    ChairLegs num;
    ChairFrame frame;
    Seat sitting;
    Manufacturer producer;
    public boolean isBroken;
    private double price;

    public Chair(double price, float frame_l, ChairLegs number, float frame_h, float frame_w, float seat_h, float seat_w, String Name, Manufacturer obj){
        super();
        back = new Backboard(50, 60);
        num = number;
        frame = new ChairFrame(frame_l, frame_h, frame_w);
        sitting = new Seat(seat_h, seat_w);
        name = Name;
        producer = obj;
        this.price = price;
    }

    public ChairLegs getLegs() {
        return num;
    }

    public Chair(String Name) {
        super();
        back = new Backboard();
        num = ChairLegs.FOUR;
        frame = new ChairFrame();
        sitting = new Seat();
        producer = new Manufacturer(Name, this);
        price = 10d;
    }

    public Chair() {
        super();
        back = new Backboard();
        num = ChairLegs.FOUR;
        frame = new ChairFrame();
        sitting = new Seat();
        producer = new Manufacturer(this.name + "`s Manufacturer", this);
        price = 10d;
    }

    public double getPrice() {
        return price;
    }
    public void isBroken() {
        isBroken = true;
    }
    public void tryToBreak(){
        int var = (int) (Math.random() * 4);
        if(var == 3) isBroken = true;
    }

    public ChairLegs getNum(){
        return num;
    }

    public Manufacturer getProducer(){
        return producer;
    }

    public Seat getSitting(){
        return sitting;
    }

    public ChairFrame getFrame(){
        return frame;
    }

    public void notBroken() {
        isBroken = false;
    }

    public boolean getIsBroken() {
        return isBroken;
    }
    public String getName(){
        return name;
    }
    public void showChair() throws BrokenChair {
        tryToBreak();
        if(isBroken) throw new BrokenChair(name + " is broken");
        System.out.println("Class Chair:\nName: " + name + ".\n");
        back.show();
        StringBuffer myStr = new StringBuffer("Class ChairLegs: ");
        myStr.append(" String value: ");
        myStr.append(num);
        myStr.append(" Integer value: ");
        myStr.append(num.getNum());
        System.out.println(myStr);
        frame.show();
        sitting.show();
        producer.show();
    }

    public void setName(String Name) {
        name = Name;
    }
}

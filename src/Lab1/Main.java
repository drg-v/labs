package Lab1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Lab1.enumeration.ChairLegs;
import Lab1.exception.BrokenChair;

class Example {

    public static void main(String[] args) {
        List<Chair> lst = new LinkedList<>();
        Manufacturer obj = new Manufacturer("Wood master");
        lst.add(new Chair(10,40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj));
        lst.add(new Chair(10,45.0f, ChairLegs.FOUR, 11.0f, 12.0f, 61.0f, 51.0f, "Second", obj));
        lst.add(new Chair(10,50.0f, ChairLegs.THREE, 12.0f, 14.0f, 62.0f, 52.0f, "Third", obj));
        lst.add(new Chair(10,55.0f, ChairLegs.FOUR, 13.0f, 16.0f, 63.0f, 53.0f, "Fourth", obj));
        lst.add(new Chair(10,60.0f, ChairLegs.THREE, 14.0f, 18.0f, 64.0f, 54.0f, "Fifth", obj));
        Iterator<Chair> chairIterator = lst.iterator();
        while (chairIterator.hasNext()) {
            Chair cur = chairIterator.next();
            try {
                cur.showChair();
            } catch (BrokenChair brokenChair) {
                System.out.println(brokenChair.getMessage());
                Repair.repairChair(cur);
            } finally {
                System.out.println("Element has been deleted.");
            }
        }
        Chair obj1 = new Chair(10,40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj);
        Chair obj2 = new Chair(10,40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj);
        System.out.println("obj1 equals obj2 is " + obj1.equals(obj2));

        Manufacturer objMan = new Manufacturer("Wood master");
        System.out.println("obj equals objMan is " + obj.equals(objMan));
    }
}
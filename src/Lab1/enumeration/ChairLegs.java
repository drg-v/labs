package Lab1.enumeration;

public enum ChairLegs {
    THREE("THREE", 3), FOUR("FOUR", 4);
    private String title;
    private int num;

    ChairLegs(String word, int num) {
        title = word;
        this.num = num;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public int getNum(){
        return num;
    }
}

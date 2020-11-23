package Lab1.exception;

public class BrokenChair extends Exception{
    private String message;

    public BrokenChair(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

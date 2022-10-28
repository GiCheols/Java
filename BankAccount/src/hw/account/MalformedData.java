package hw.account;

public class MalformedData extends Exception{
    public MalformedData(){
        super("잘못된 금액");
    }
}

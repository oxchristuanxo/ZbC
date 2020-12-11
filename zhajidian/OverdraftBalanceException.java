package zhajidian;

public class OverdraftBalanceException extends RuntimeException{
    public OverdraftBalanceException(String ErrorMessage){
        super(ErrorMessage);

    }
}

package bankdemo.bankdemosp.exception;

public class BankException extends RuntimeException{
    public BankException(Long id)
    {
        super("The account id is not existed "+id);
    }
}

package microservicedeneme.service.exception;
@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("Account cannot find");
    }
}

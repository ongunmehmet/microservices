package microservicedeneme.service.exception;

public class AccountAlreadyExistException extends RuntimeException {
    public AccountAlreadyExistException() {
        super("Accound already exist ");
    }
}

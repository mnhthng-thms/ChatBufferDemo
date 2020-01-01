package Model.CustomExceptions;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("\nYour message can not be blank!\nRetry please!");
    }
}

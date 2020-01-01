package Model.CustomExceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("\nInvalid input! Please retry!");
    }
}

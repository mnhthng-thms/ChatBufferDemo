package Model.CustomExceptions;

public class StringTooLongException extends Exception{
    public StringTooLongException(){
        super("\nYour message exceeds the string limit of 250. Please retry!");
    }
}

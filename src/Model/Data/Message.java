package Model.Data;

import Model.CustomExceptions.StringTooLongException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EmptyStackException;

public class Message {
    private String content;
    private User sender;
    private String timeSent;
    public final int CHARACTERS_LIMIT = 250;

    public Message(User sender, String content) {
        this.sender = sender;

        // set timeSent as the time in which message input is enqueued
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // (LocalDateTime now) -> String timeSent
        this.timeSent = now.format(formatter);

        // input message can not be neither empty or longer than 250 character
        if (content == null || content.isEmpty()) {
            throw new EmptyStackException();
        } else if (content.length() > CHARACTERS_LIMIT) {
            try {
                throw new StringTooLongException();
            } catch (StringTooLongException e) {
                e.printStackTrace();
            }
        } else {
            this.content = content;
        }
    }
    public User getSender() { return this.sender; }

    // define string representation of Message object
    public String toString() {
        return String.format("[%s] %s•> \'%s\'\n", timeSent, sender.toString(), content);
    }
}

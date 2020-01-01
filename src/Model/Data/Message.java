package Model.Data;

import Model.CustomExceptions.StringTooLongException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EmptyStackException;

public class Message {
    private String content;
    private User sender;
    private String timeSent;
    public final int STRING_LIMIT = 250;

    public Message(User sender, String content) {
        this.sender = sender;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // (LocalDateTime now) -> String timeSent
        this.timeSent = now.format(formatter);

        if (content == null || content.isEmpty()) {
            throw new EmptyStackException();
        } else if (content.length() > STRING_LIMIT) {
            try {
                throw new StringTooLongException();
            } catch (StringTooLongException e) {
                e.printStackTrace();
            }
        } else {
            this.content = content;
        }
    }

    public String getContent() {
        return content;
    }
    public User getSender() {
        return sender;
    }
    public String getTimeSent() {
        return timeSent;
    }

    public String toString() {
        return String.format("[%s] %s•> \'%s\'\n", timeSent, sender.toString(), content);
    }
}

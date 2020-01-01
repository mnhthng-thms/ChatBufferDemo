package Model.Data;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MessageQueue {
    private ArrayList<Message> queue = new ArrayList<Message>();

    public MessageQueue(){}

    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public void clear() {
        queue.clear();
    }

    public void enqueue(User sender, String messageContent) {
        Message tmp = new Message(sender, messageContent);
        queue.add(tmp);
    }

    public void dequeueMessageOf(User usr) {
        // java.util.LinkedList.removeLast() remove and return the removed object
        try {
            for (int i = queue.size()-1; i >= 0; i--) {
                if (queue.get(i).getSender() == usr) {
                    queue.remove(i);
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(String.format("No %s\'s message found! No messages removed!",usr.toString()));
            e.printStackTrace();
        }
    }

    public String toString() {
        String tmp = "";
        for (Message o: queue) {
            tmp += o.toString();
        }
        return tmp;
    }

    public ArrayList<String> toStringList() {
        ArrayList<String> tmp = new ArrayList<String>();
        for (Message o: queue) {
            tmp.add(o.toString());
        }
        return tmp;
    }
}

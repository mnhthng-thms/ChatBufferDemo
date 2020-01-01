package Model.Data;

import java.util.ArrayList;

public class MessageBuffer {
    private ArrayList<String> stack = new ArrayList<String>();

    public MessageBuffer() {
    }

    public int size() {
        if (!stack.isEmpty()) {
            return stack.size();
        }
        return 0;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void stackFrom(MessageQueue tmpQueue) {
        stack.clear();
        ArrayList<String> cloned = tmpQueue.toStringList();
        for (int i= cloned.size()-1; i >= 0; i--) {
            stack.add(cloned.get(i));
        }
    }

    public String toString() {
        String tmp = "";
        for (String el: stack) {
            tmp += el;
        }
        return tmp;
    }
}

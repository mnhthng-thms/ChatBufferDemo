package View;

import Model.CustomExceptions.InvalidInputException;
import Model.Data.MessageBuffer;
import Model.Data.MessageQueue;
import Model.Data.User;

import static Controller.InputHandlers.getInput;
import static Controller.InputHandlers.getChoice;


public class UserInterface {
    private static User user1 = new User();
    private static User user2 = new User("Tom");
    private static MessageQueue runtimeQueue = new MessageQueue();
    private static MessageBuffer runtimeBuffer = new MessageBuffer();

    public static void printMain() {
        System.out.println("•••CHAT BUFFER DEMO by Hoang Minh Tu•••");
        System.out.println(String.format("[1] Send a message as '%s'",user1));
        System.out.println(String.format("[2] Send a message as '%s'",user2));
        System.out.println(String.format("[3] Delete the latest message sent by '%s'",user1));
        System.out.println(String.format("[4] Delete the latest message sent by '%s'",user2));
        System.out.println("[5] View chat history (from the latest messages to the oldest one)");
        System.out.println("[6] Clear chat history");
        System.out.println("[0] Exit");
    }

    public static void sendMessage(User sender) {
        String inputMsg = getInput("Type your message: ");
        runtimeQueue.enqueue(sender, inputMsg);
    }

    public static void viewAllMessages() throws InvalidInputException {
        System.out.println();
        // Re-fetch the runtime buffer and print its string representation out
        runtimeBuffer.stackFrom(runtimeQueue);
        System.out.println(runtimeBuffer.toString());
        /*if (runtimeBuffer.isEmpty()) {
            System.out.println("There are no messages yet!");
        } else {
        int j = 0;
        int bufferSize = runtimeBuffer.size();
        while (j < bufferSize) {
            System.out.println("------------------------------------------------");
            System.out.println(String.format("| %s", runtimeBuffer.getByIndex(j)));
            System.out.println("------------------------------------------------");
            System.out.println(String.format("Page %n of %n. ", j, bufferSize));
            if (j < (bufferSize - 1)) {
                System.out.print("Press [1] to see the next page. Press [0] to return to Main Menu.");
                int inputKey = getChoice();
                switch (inputKey) {
                    case 0:
                        break;
                    case 1:
                        j++;
                        break;
                    default:
                        throw new InvalidInputException();
                }
            }
        }*/
    }


    public static void clearAllMesssages() throws InvalidInputException {
        System.out.println("Are you sure? [1] for yes and [0] for no.");
        int inputKey = getChoice();
        switch (inputKey) {
            case 0:
                System.out.println("Nothing happened!");
                break;
            case 1:
                runtimeQueue.clear();
                System.out.println("Done!");
                break;
            default:
                throw new InvalidInputException();
        }
    }

    public static void main(String[] args) {
        boolean isRunning = true;

        System.out.println(String.format("First user: '%s', second user: '%s'",user1.toString(),user2.toString()));
        System.out.println();
        while (isRunning) {
            printMain();
            int inputKey = getChoice();
            switch (inputKey) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    try {
                        sendMessage(user1);
                        System.out.println();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 2:
                    try {
                        sendMessage(user2);
                        System.out.println();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 3:
                    try {
                        runtimeQueue.dequeueMessageOf(user1);
                        System.out.println();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case 4:
                    try {
                        runtimeQueue.dequeueMessageOf(user2);
                        System.out.println();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 5:
                    try {
                        viewAllMessages();
                        System.out.println();
                        break;
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                case 6:
                    try {
                        clearAllMesssages();
                        System.out.println();
                        break;
                    } catch (InvalidInputException e) {
                        e.printStackTrace();
                    }
                default:
                    try {
                        throw new InvalidInputException();
                    } catch (InvalidInputException e) {
                        System.out.println("Please retry!");
                    }
            }
        }
    }
}

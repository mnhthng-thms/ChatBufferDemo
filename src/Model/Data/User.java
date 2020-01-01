package Model.Data;

import java.util.Random;

public class User {
    private String nickname;

    public User() {
        Random generator = new Random();
        String[] namePool = {"Alan", "Bob", "Cain", "Dick", "Eiiyo", "Henry",
                "John", "Meimei", "Gerald", "Foofoo", "Meow", "Ishaaq", "Weeboo", "Jake", "Zhang"};
        this.nickname = namePool[generator.nextInt(namePool.length)];

        System.out.println(String.format("An user account created, nickname: \'%s\'",this.nickname));
    }

    public User(String nickname) {
        this.nickname = nickname;

        System.out.println(String.format("An user account created, nickname: \'%s\'",this.nickname));
    }

    public String toString() {
        return nickname;
    }
}

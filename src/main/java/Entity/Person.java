package Entity;

import java.util.UUID;

public class Person {
    private UUID id;
    private String name;
    private int age;

    public Person(UUID id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

package pl.edu.agh.to.lab4;

public abstract class Suspect {
    private final String firstName;
    private final String lastName;

    public Suspect(String name, String lastname){
        this.firstName = name;
        this.lastName = lastname;
    }


    public String getFirstName(){
        return this.firstName;
    }


    public String getLastName(){
        return this.lastName;
    }

    public abstract boolean canBeAccused();

    public String display() {
        return firstName + " " + lastName;
    }

    public abstract int getAge();
}

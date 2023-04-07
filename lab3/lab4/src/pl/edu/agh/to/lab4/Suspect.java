package pl.edu.agh.to.lab4;

public abstract class Suspect {
    private String firstName;
    private String lastName;

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

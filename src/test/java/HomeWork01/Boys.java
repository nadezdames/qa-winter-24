package HomeWork01;

public class Boys {
    private String name = "Zhenja";
    private boolean isThisaBoy = true;
    private int age = 69;
    private long socialSecurityNumber = 46648854624L;
    private double masculinity = 76.84;

    //---------GETTERS/SETTERS---------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isThisaBoy() {
        return isThisaBoy;
    }

    public void setThisaBoy(boolean thisaBoy) {
        isThisaBoy = thisaBoy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getMasculinity() {
        return masculinity;
    }

    public void setMasculinity(double masculinity) {
        this.masculinity = masculinity;
    }
}

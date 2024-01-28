package HomeWork01;

public class Plants {
    private String color = "Green";
    private boolean beautiful = false;
    private boolean blooming = true;
    private long socialSecurityNumber =1000000001L;
    private boolean customPotIncluded = true;

    //---------GETTERS/SETTERS---------

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBeautiful() {
        return beautiful;
    }

    public void setBeautiful(boolean beautiful) {
        this.beautiful = beautiful;
    }

    public boolean isBlooming() {
        return blooming;
    }

    public void setBlooming(boolean blooming) {
        this.blooming = blooming;
    }

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public boolean isCustomPotIncluded() {
        return customPotIncluded;
    }

    public void setCustomPotIncluded(boolean customPotIncluded) {
        this.customPotIncluded = customPotIncluded;
    }
}

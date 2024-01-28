package HomeWork01;

public class Cars {
    private String modelName = "Nissan";
    private boolean fast = false;
    private char modelType = 'a';
    private long carMileage = 200000L;
    private String color = "White";

    //---------GETTERS/SETTERS---------

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public boolean isFast() {
        return fast;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }

    public char getModelType() {
        return modelType;
    }

    public void setModelType(char modelType) {
        this.modelType = modelType;
    }

    public long getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(long carMileage) {
        this.carMileage = carMileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

package HomeWork01;

public class Cats {
    private String name = "lex_coldfish";
    private boolean chonk = true;
    private int age = 5;
    private String colour = "White, Brown and Ginger";
    private float weight = 6.84F;

    //---------GETTERS/SETTERS---------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChonk() {
        return chonk;
    }

    public void setChonk(boolean chonk) {
        this.chonk = chonk;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

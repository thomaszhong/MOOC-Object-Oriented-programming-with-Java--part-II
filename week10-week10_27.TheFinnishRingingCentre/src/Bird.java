
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    public String getLatinName() {
        return this.latinName;
    }
    
    public int getRingingYear() {
        return this.ringingYear;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (getClass() != o.getClass()) {
            return false;
        }
        
        Bird bird = (Bird) o;
        return this.latinName.equals(bird.getLatinName()) && this.ringingYear
                == bird.getRingingYear();
    }
    
    @Override
    public int hashCode() {
        return this.latinName.hashCode() + this.ringingYear;
    }
}



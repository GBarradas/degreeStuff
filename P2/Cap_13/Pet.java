public class Pet {

    private String name;
    private String specie;

    public Pet(String name, String specie){
        this.name=name;
        this.specie=specie;
    }

    public String toString(){
        return specie + " " + name;
    }

    
}
package Lab1;

public class Manufacturer implements ShowDimensions {
    private String name;
    private Chair[] models;

    public Manufacturer(String Name, Chair... objects){
        name = Name;
        if(objects.length > 0) {
            models = new Chair[objects.length];
            for (int i = 0; i < objects.length; i++) {
                models[i] = objects[i];
            }
        } else {
            models = new Chair[1];
            models[0] = new Chair(name);
        }
    }

    public void show(){
        String result;
        result = name.contains("Manufacturer") ? name.split(" ")[0] : name;
        System.out.println(" Name: " + result + " \nposition: Manufacturer.\n");
    }

    public String getName(){
        return name;
    }

    public int getModelsLength(){
        return models.length;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }
    
    public boolean equals(Manufacturer obj) {
        if(this.hashCode() != obj.hashCode()) return false;
        if(this.hashCode() == obj.hashCode()) {
            for (int i = 0; i < this.models.length; i++) {
                if (this.models[i].name != obj.models[i].name) return false;
            }
        }
        return true;
    }
}

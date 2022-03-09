import java.util.Map;

public class Challenge4 {
    public static void main(String[] args) {
        //parent
        Animals animals = new Animals();
        animals.identifyMyself();
        //child
        //herbivor
        Herbivor herbivor = new Herbivor("Kambing");
        herbivor.identifyMyself();
        //carnivor
        Carnivor carnivor = new Carnivor("Singa");
        carnivor.identifyMyself();
        //omnivor
        Omnivor omnivor = new Omnivor("Ayam");
        omnivor.identifyMyself();
    }
}

//parent
class Animals {
    //ATTR
    private String name;
    private String food;
    private String teeth;

    //CONSTRUCTOR
    public Animals() {
        //
        this.name = "Binatang";
    }

    public Animals(String name, String food, String teeth) {
        this.name = name;
        this.food = food;
        this.teeth = teeth;
    }

    //GETTER SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getTeeth() {
        return teeth;
    }

    public void setTeeth(String teeth) {
        this.teeth = teeth;
    }

    //ADDITIONAL METHOD
    public void identifyMyself() {
        System.out.println("Hi I'm Parent of All Animals, My name is "+getName());
    }

}

//child
class Herbivor extends Animals {

    //CONSTRUCTOR
    public Herbivor() {
        //
    }

    public Herbivor(String name) {
        setName(name);
        setFood("tumbuhan");
        setTeeth("tumpul");
    }

    @Override
    public void identifyMyself() {
        //super.identifyMyself();
        System.out.println("Hi I'm Herbivor, My name is "+getName()+", My food is "+getFood()+", I have "+getTeeth()+" teeth");
    }
}

class Carnivor extends Animals {

    //CONSTRUCTOR
    public Carnivor(String name) {
        setName(name);
        setFood("daging");
        setTeeth("tajam");
    }

    @Override
    public void identifyMyself() {
        //super.identifyMyself();
        System.out.println("Hi I'm Carnivor, My name is "+getName()+", My food is "+getFood()+", I have "+getTeeth()+" teeth");
    }
}

class Omnivor extends Animals {
    //CONSTRUCTOR
    public Omnivor(String name) {
        setName(name);
        setFood("semua");
        setTeeth("tajam dan tumpul");
    }

    @Override
    public void identifyMyself() {
        //super.identifyMyself();
        System.out.println("Hi I'm Omnivor, My name is "+getName()+", My food is "+getFood()+", I have "+getTeeth()+" teeth");
    }
}
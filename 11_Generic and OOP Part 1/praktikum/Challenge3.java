public class Challenge3 {

    public static void main(String[] args) {
        //parent
        Vehicle vehicle = new Vehicle("Gerobak","no engine");
        vehicle.identifyMyself();
        System.out.println();
        //child
        //bikes
        Bikes bikes1 = new Bikes("Pedal Bikes","no engine",2);
        bikes1.identifyMyself();
        Bikes bikes2 = new Bikes("Motor Bikes","with engine",2);
        bikes2.identifyMyself();
        System.out.println();
        //car
        Cars cars1 = new Cars("Sport Cars","with engine",4,"V8");
        cars1.identifyMyself();
        Cars cars2 = new Cars("Pickup Cars","with engine",4,"Solar");
        cars2.identifyMyself();
        System.out.println();
        //buses
        Buses buses1 = new Buses("Trans Jakarta","with engine",4,"Public Bus");
        buses1.identifyMyself();
        Buses buses2 = new Buses("School Bus","with engine",4,"Private Bus");
        buses2.identifyMyself();
    }

}

//parent
class Vehicle {
    //ATTR
    private String name;
    private String withEngine;
    //enum withEngine {WITH_ENGINE, NO_ENGINE}

    //CONSTRUCTOR
    public Vehicle() {
    }

    public Vehicle(String name, String withEngine) {
        this.name = name;
        this.withEngine = withEngine;
    }

    //GETTER SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWithEngine() {
        return withEngine;
    }

    public void setWithEngine(String withEngine) {
        this.withEngine = withEngine;
    }

    //ADDITIONAL METHOD
    public void identifyMyself() {
        System.out.println("Hi I'm Parent of All Vehicles, My name is "+getName()+", My engine status is "+getWithEngine());
    }

}

//child
class Bikes extends Vehicle {

    //ATTR
    private int wheelCount;

    //CONSTRUCTOR
    public Bikes(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public Bikes(String name, String withEngine, int wheelCount) {
        super(name, withEngine);
        this.wheelCount = wheelCount;
    }

    //GETTER SETTER
    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    //ADDITIONAL METHOD

    @Override
    public void identifyMyself() {
        System.out.println("Hi I'm Bike, My name is "+getName()+", My engine status is "+getWithEngine()+", I have "+getWheelCount()+" wheel(s)");
    }
}

class Cars extends Vehicle {

    //ATTR
    private int wheelCount;
    private String engineType;

    //CONSTRUCTOR
    public Cars(int wheelCount, String engineType) {
        this.wheelCount = wheelCount;
        this.engineType = engineType;
    }

    public Cars(String name, String withEngine, int wheelCount, String engineType) {
        super(name, withEngine);
        this.wheelCount = wheelCount;
        this.engineType = engineType;
    }

    //GETTER SETTER
    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    //ADDITIONAL METHOD

    @Override
    public void identifyMyself() {
        System.out.println("Hi I'm Car, My name is "+getName()+", My engine status is "+getWithEngine()+", I have "+getWheelCount()+" wheel(s), My engine type = "+getEngineType());
    }
}

class Buses extends Vehicle {

    //ATTRIBUTE
    private int wheelCount;
    private String pivateBus;

    //CONSTRUCTOR
    public Buses(int wheelCount, String pivateBus) {
        this.wheelCount = wheelCount;
        this.pivateBus = pivateBus;
    }

    public Buses(String name, String withEngine, int wheelCount, String pivateBus) {
        super(name, withEngine);
        this.wheelCount = wheelCount;
        this.pivateBus = pivateBus;
    }

    //GETTER SETTER
    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public String getPivateBus() {
        return pivateBus;
    }

    public void setPivateBus(String pivateBus) {
        this.pivateBus = pivateBus;
    }

    //ADDITIONAL METHOD

    @Override
    public void identifyMyself() {
        System.out.println("Hi I'm Bus ["+getPivateBus()+"], My name is "+getName()+", My engine status is "+getWithEngine()+", I have "+getWheelCount()+" wheel(s)");

    }
}
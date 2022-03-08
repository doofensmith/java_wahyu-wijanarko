public class Challenge1 {
    public static void main(String[] args) {

        //Cat
        Cat cat1 = new Cat(5,"hijau metallik");
        cat1.showIdentity();

        //Fish
        Fish fish1 = new Fish("cupang","seledri");
        fish1.showIdentity();

        //Flower
        Flower flower1 = new Flower("pasir","coklat metallik",4);
        flower1.showIdentity();

        //Car
        Car car1 = new Car("TDR-3000","hitam metallik",5);
        car1.showIdentity();

    }

}

class Cat {
    //ATTR
    private int jumlahKaki;
    private String warnaBulu;

    //CONSTRUCTOR
    public Cat() {
        //
    }

    public Cat(int jumlahKaki, String warnaBulu) {
        this.jumlahKaki = jumlahKaki;
        this.warnaBulu = warnaBulu;
    }

    //GETTER N SETTER
    public int getJumlahKaki() {
        return jumlahKaki;
    }

    public void setJumlahKaki(int jumlahKaki) {
        this.jumlahKaki = jumlahKaki;
    }

    public String getWarnaBulu() {
        return warnaBulu;
    }

    public void setWarnaBulu(String warnaBulu) {
        this.warnaBulu = warnaBulu;
    }

    //ADDITIONAL METHOD
    public void showIdentity() {
        System.out.println("Saya kucing dengan detail, warna bulu : " + getWarnaBulu() + " dengan jumlah kaki : " + getJumlahKaki());
    }

}

class Fish {
    //ATTR
    private String type;
    private String feed;

    //CONSTRUCTOR

    public Fish() {
        //
    }

    public Fish(String type, String feed) {
        this.type = type;
        this.feed = feed;
    }

    //GETTER SETTER

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    //ADDITIONAL METHOD
    public void showIdentity() {
        System.out.println("Saya ikan dengan detail, jenis : " + getType() + " dengan makanan : " + getFeed());
    }

}

class Flower {
    //ATTR
    private String name;
    private String color;
    private int numberOfPetal;

    //CONSTRUCTOR

    public Flower() {
        //
    }

    public Flower(String name, String color, int numberOfPetal) {
        this.name = name;
        this.color = color;
        this.numberOfPetal = numberOfPetal;
    }

    //GETTER AND SETTER

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfPetal() {
        return numberOfPetal;
    }

    public void setNumberOfPetal(int numberOfPetal) {
        this.numberOfPetal = numberOfPetal;
    }

    //ADDITIONAL METHOD
    public void showIdentity() {
        System.out.println("Saya bunga dengan detail, jenis : "+getName()+", color : "+getColor()+", num of petal : "+getNumberOfPetal());
    }
}

class Car {
    //ATTR
    private String type;
    private String color;
    private int numOfTires;

    //CONSTRUCTOR

    public Car() {
        //
    }

    public Car(String type, String color, int numOfTires) {
        this.type = type;
        this.color = color;
        this.numOfTires = numOfTires;
    }

    //GETTER AND SETTER

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumOfTires() {
        return numOfTires;
    }

    public void setNumOfTires(int numOfTires) {
        this.numOfTires = numOfTires;
    }

    //ADDITIONAL METHOD
    public void showIdentity() {
        System.out.println("Saya mobil dengan detail, type : "+getType()+", color : "+getColor()+", num of tire : "+getNumOfTires());
    }
}



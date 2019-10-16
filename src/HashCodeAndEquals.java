class Laptop {
    int price;
    int weight;

    public Laptop(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Laptop lap = (Laptop)obj;

        if (this.price == lap.price && this.weight == lap.weight) {
            return true;
        }
        return false;
    }
}


public class HashCodeAndEquals {
    public static void main(String[] args) {
        Laptop lap1 = new Laptop(5, 10);
        Laptop lap2 = new Laptop(5, 10);
        Laptop lap3 = null;
        System.out.println(lap1.equals(lap2));
        System.out.println(lap1.equals(lap3));
        System.out.println(lap1.equals(5));
        System.out.println(lap1.hashCode());
        System.out.println(lap2.hashCode());
    }
}

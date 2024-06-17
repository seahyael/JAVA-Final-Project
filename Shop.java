package project;

public class Shop {
    String name;
    String makers;
    double price;
    int num;

    public Shop(String name, String makers, double price, int num) {
        this.name = name;
        this.makers = makers;
        this.price = price;
        this.num = num;
    }

    public Shop (String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMakers() {
        return name;
    }

    public void setMakers(String makers) {
        this.makers = makers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Shopping list {" +
                "name='" + name + '\'' +
                ", makers='" + makers + '\'' +
                ", price=" + price +
                ", number=" + num +
                '}';
    }
}
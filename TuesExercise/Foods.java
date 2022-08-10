package TuesExercise;

import javax.swing.*;
import java.security.PrivateKey;

public class Foods {
    private double temperature;
    private double price;
    private String name;
    private String consumer;
    private String taste;
    private String color;
    //constructors
    public Foods(double temperature, double price, String name, String consumer, String taste, String color) {
        this.temperature = temperature;
        this.price = price;
        this.name = name;
        this.consumer = consumer;
        this.taste = taste;
        this.color = color;
    }

    public Foods() {
        this.temperature = 0;
        this.price = 0;
        this.name = null;
        this.consumer = null;
        this.taste = null;
        this.color = null;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    //methods
    public void boil() {
        System.out.println(this.consumer + " prepared " + this.name + " and boiled it at a temperature of " + this.temperature);
    }

    public void bake() {
        System.out.println("The " + this.taste + " taste of " + this.color + " " + this.name + " is baking at " + this.temperature + " F");
    }

    public void lowerPrice() {
        double product = 0;
        System.out.println("This item is discounted: " + this.name);
        product += this.price * 0.5;
        System.out.println("Current price: " + product);
    }





}

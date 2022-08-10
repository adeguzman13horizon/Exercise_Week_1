package TuesExercise;

public class Soup extends Foods{
    private String form;

    public Soup(double temperature, double price, String name, String consumer, String taste, String color, String form) {
        super(temperature, price, name, consumer, taste, color);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public void boil() {
        System.out.println(super.getConsumer() + " stopped boiling the " + super.getColor() + " " + super.getName());
        System.out.println("Current temperature of soup: " + super.getTemperature());
    }

    public void boil(String form) {
        System.out.println("After boiling the " + super.getName() + " , its form stays as a " + this.form);
    }

    @Override
    public void lowerPrice() {
        super.lowerPrice();
        System.out.println("Our initial price: " + getPrice());
    }


}

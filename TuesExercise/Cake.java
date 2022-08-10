package TuesExercise;

public class Cake extends Foods{

    private int candles;

    public Cake(double temperature, double price, String name, String consumer, String taste, String color, int candles) {
        super(temperature, price, name, consumer, taste, color);
        this.candles = candles;
    }

    public int getCandles() {
        return candles;
    }

    public void setCandles(int candles) {
        this.candles = candles;
    }

    @Override
    public void bake() {
        System.out.println("The " + super.getName() + " is being baked at: " + super.getTemperature());
        System.out.println("It will maintain its " + super.getTaste() + " flavor and " + super.getColor() + " color");
    }

    public void bake(int candles) {
        System.out.println(super.getConsumer() + " placed " + this.candles + " candles on the cake after baking it");
    }

    @Override
    public void lowerPrice() {
        double product = 0;
        System.out.println("This item is doubled in price: " + super.getName());
        product += super.getPrice() * 2;
        System.out.println("Current price: " + product);
    }


}

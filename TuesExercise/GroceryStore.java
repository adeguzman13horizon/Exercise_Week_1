package TuesExercise;

public class GroceryStore {
    public static void main(String[] args) {
        Foods f = new Foods(180.0, 45.00, "turkey", "Caleb", "gamey", "light brown");

        Soup s1 = new Soup(212.0, 5.00, "tomato soup","Johnny", "fruity", "red", "smooth liquid");
        Soup s2 = new Soup(175.0, 7.00, "chicken noodle soup","Ron", "salty", "yellow", "chunky liquid");
        Soup s3 = new Soup(125.0, 10.00, "hot and sour soup","Lin", "sour", "brown", "chunky liquid");

        Cake c1 = new Cake(375.0, 17.00, "caramel", "Joan", "rich", "light brown", 3);
        Cake c2 = new Cake(425.0, 25.00, "chocolate", "Caesar", "sweet", "dark brown", 1);
        Cake c3 = new Cake(455.0, 30.00, "red velvet", "Sarah", "creamy", "dark red", 7);

        f.bake();
        f.lowerPrice();

        s1.boil();
        s1.boil("smooth liquid");
        s1.lowerPrice();
        s2.boil();
        s2.boil("chunky liquid");
        s2.lowerPrice();
        s3.boil();
        s3.boil("chunky liquid");
        s3.lowerPrice();

        c1.bake();
        c1.bake(3);
        c1.lowerPrice();
        c2.bake();
        c2.bake(1);
        c2.lowerPrice();
        c3.bake();
        c3.bake(7);
        c3.lowerPrice();

        s1.setPrice(17.0);
        System.out.println(s1.getPrice());
        s1.lowerPrice();

        s2.setPrice(5.0);
        System.out.println(s2.getPrice());
        s2.lowerPrice();

        c3.setName("strawberry shortcake");
        System.out.println(c3.getName());
        c3.bake();




    }
}

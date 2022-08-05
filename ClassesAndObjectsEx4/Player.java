package ClassesAndObjectsEx4;
import java.util.*;
public class Player {
    //data members, variables
    String name;
    String skill;
    int age;
    int level;
    int health;

    //constructors
    public Player(String name, String skill, int age, int level, int health) {
        this.name = name;
        this.skill = skill;
        this.age = age;
        this.level = level;
        this.health = health;
    }
    public Player(String name, String skill, int level, int health) {
        this.name = name;
        this.skill = skill;
        this.level = level;
        this.health = health;
    }
    public Player() {
        this.name = "Werewolf";
        this.skill = "bite";
        this.level = 100;
        this.health = 100;
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public String toString() {
        String myReturn = "";
        myReturn += name + " has the " + skill + " skill and the following are its stats. ";
        myReturn += "Age: " + age + ", " + " Level: " + level + ", " + " Health: " + health;
       return myReturn;
    }

    @Override
    public boolean equals(Object obj) {
        Player player = (Player) obj;
        if (!(obj instanceof Player)) return false;

        if (!this.name.equalsIgnoreCase(player.name))
            return false;
        if (!this.skill.equals(player.skill))
            return false;
        if (this.age != player.age)
            return false;
        if (this.level != player.level)
            return false;
        if (this.health != player.health)
            return false;

        return true;
    }

    public void damageDealt() {
        System.out.println("Under Attack!");
        this.health = health;
        while (this.health >= 0) {
            System.out.println(this.health);
           this.health-=15;
           System.out.println("Lost 15 damage");
        }
        System.out.println("Character has been defeated!");
    }

    public void increaseCharacterStats() {
        System.out.println("Select which stat to boost your character!:\nAge\nLevel\nHealth");
        String input = sc.next();
        switch (input) {
            case "Age" :
                System.out.println("Age increased up by 5!");
                System.out.println(this.age+=5);
                break;
            case "Level" :
                System.out.println("Level increased up by 10!");
                System.out.println(this.level+=10);
                break;
            case "Health" :
                System.out.println("Health increased up by 20!");
                System.out.println(this.health+=20);
                break;
            default: System.out.println("These three options can only be selected.");
        }
        System.out.println("You have successfully changed your character's stats!");
    }

    public void characterHappiness(int bonding) {
        System.out.println("The bonding ability of " + this.name + " has been set to: " + bonding);
        System.out.println("Since this feature was unlocked for the first time, additional points will be added:");
        System.out.println(bonding+=10);
    }











}

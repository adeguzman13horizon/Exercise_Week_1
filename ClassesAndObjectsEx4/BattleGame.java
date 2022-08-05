package ClassesAndObjectsEx4;

public class BattleGame {
    public static void main(String[] args) {
        Player p1 = new Player("Magician", "spellcast", 85, 70, 100 );
        Player p2 = new Player("Warrior", "slash", 60, 50);
        Player p3 = new Player();
        Player p4 = new Player("warrior", "slash", 60, 50);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());


        System.out.println("Matching the two warrior players: " + p2.equals(p4));
        if (p2.equals(p4)) {
            System.out.println("These players have same profile and stats.");
        } else {
            System.out.println("These players' profile and stats do not match ");
        }
        System.out.println("Matching " + p1.name + " and " + p2.name + " players: " + p1.equals(p2));
        if (p1.equals(p2)) {
            System.out.println("These players have same profile and stats.");
        } else {
            System.out.println("These players' profile and stats do not match ");
        }
        System.out.println("Matching " + p1.name + " and " + p3.name + " players: " + p1.equals(p3));
        if (p1.equals(p3)) {
            System.out.println("These players have same profile and stats.");
        } else {
            System.out.println("These players' profile and stats do not match ");
        }
        System.out.println("Matching " + p2.name + " and " + p3.name + " players: " + p2.equals(p3));
        if (p2.equals(p3)) {
            System.out.println("These players have same profile and stats.");
        } else {
            System.out.println("These players' profile and stats do not match ");
        }


        p1.damageDealt();
        p1.increaseCharacterStats();
        p1.characterHappiness(30);

        p2.damageDealt();
        p2.increaseCharacterStats();
        p2.characterHappiness(12);

        p3.damageDealt();
        p3.increaseCharacterStats();
        p3.characterHappiness(5);

        p4.damageDealt();
        p4.increaseCharacterStats();
        p4.characterHappiness(2);



















    }
}

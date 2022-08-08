package Week2_MonChallenge;
import java.util.*;
public class CodingChallenge {
    public static void main(String[] args) {
        //Solution #1:
        int[] array1 = {10,16,25,35,46,52,55,70,77,100};
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }

        for (int i2 = array1.length - 1; i2 >= 0; i2--) {
            System.out.println(array1[i2]);
        }



        //Solution #2:
        String[] countries = {"Japan", "China", "Korea", "India", "Vietnam", "Thailand"};
        for (int str = 0; str <= countries.length - 1; str++) {
            System.out.println(reverse(countries[str]));
        }
        for (int str2 = countries.length - 1; str2 >= 0;  str2--) {
            System.out.println(reverse(countries[str2]));
        }
    }

    public static String reverse(String countries) {
        return new StringBuilder(countries)
                .reverse()
                .toString();
    }

}

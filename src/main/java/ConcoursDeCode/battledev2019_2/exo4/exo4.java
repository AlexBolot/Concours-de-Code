package ConcoursDeCode.battledev2019_2.exo4;

import java.util.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo4	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 26/11/2019 21:17
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings("ALL")
public class exo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        int stonesCount = Integer.parseInt(line.split(" ")[0]);
        int powdersCount = Integer.parseInt(line.split(" ")[1]);
        int lampCapacity = Integer.parseInt(line.split(" ")[2]);

        List<Stone> stones = new ArrayList<>();
        List<Powder> powders = new ArrayList<>();

        for (int i = 0; i < stonesCount; i++) {
            line = sc.nextLine();
            stones.add(new Stone(line.split(" ")[0], line.split(" ")[1]));
        }

        for (int i = 0; i < powdersCount; i++) {
            line = sc.nextLine();
            powders.add(new Powder(line.split(" ")[0], line.split(" ")[1]));
        }

        System.out.println(stones.toString());
        System.out.println(powders.toString());


    }

    private static class Stone{
        int value;
        int weight;

        public Stone(String value, String weight) {
            this.value = Integer.parseInt(value);
            this.weight = Integer.parseInt(weight);
        }

        @Override
        public String toString() {
            return "Stone{" +
                    "value=" + value +
                    ", weight=" + weight +
                    '}';
        }
    }

    private static class Powder{
        int value;
        int quantity;

        public Powder(String value, String quantity) {
            this.value = Integer.parseInt(value);
            this.quantity = Integer.parseInt(quantity);
        }

        @Override
        public String toString() {
            return "Powder{" +
                    "value=" + value +
                    ", quantity=" + quantity +
                    '}';
        }
    }
}
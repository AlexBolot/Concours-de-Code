package ConcoursDeCode.codingBattle2018.exo3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/03/18 20:33
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class exo3 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String thridLine = scanner.nextLine();

        ArrayList<Integer> myGrades = new ArrayList<>();
        ArrayList<ArrayList<Integer>> friendsGrades = new ArrayList<>();
        int numberOfFriends = Integer.valueOf(secondLine);
        int numberOfBFF = Integer.valueOf(thridLine);

        for (String string : firstLine.split(" ")) {
            myGrades.add(Integer.valueOf(string));
        }

        for (int i = 0; i < numberOfFriends; i++) {
            ArrayList<Integer> grades = new ArrayList<>();

            for (String s : scanner.nextLine().split(" ")) {
                grades.add(Integer.valueOf(s));
            }

            friendsGrades.add(grades);
        }

        ArrayList<ArrayList<Integer>> sortedValues = new ArrayList<>();
        for (ArrayList<Integer> friendsGrade : friendsGrades) {
            sortedValues.add(friendsGrade);
        }
        sortedValues.sort(Comparator.comparingInt(o -> getDistance(myGrades, o)));

        ArrayList<Integer> bob = new ArrayList<>();

        for (int i = 0; i < numberOfBFF; i++) {
            bob.add(sortedValues.get(i).get(sortedValues.get(i).size() - 1));
        }

        int result = 0;

        for (int i : bob) {
            result += i;
        }

        result /= numberOfBFF;

        System.out.println(result);
    }

    private static int getDistance(ArrayList<Integer> myGrades, ArrayList<Integer> hisGrades) {
        int distance = 0;

        for (int i = 0; i < myGrades.size(); i++) {
            distance += Math.abs(myGrades.get(i) - hisGrades.get(i));
        }

        return distance;
    }
}

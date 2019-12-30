package ConcoursDeCode.battledev2019_2.exo3;

import java.util.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 3/26/19 8:48 PM
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings("ALL")
public class exo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        int cables = Integer.parseInt(line.split(" ")[0]);
        int engineers = Integer.parseInt(line.split(" ")[1]);

        Map<Integer, Integer> attributions = new HashMap<>();
        Map<Integer, Integer[]> requests = new HashMap<>();

        List<Integer> results = new ArrayList<>();

        for (int i = 1; i < cables + 1; i++) {
            attributions.put(i, -1);
        }

        for (int i = 0; i < engineers; i++) {
            line = sc.nextLine();
            requests.put(i, new Integer[]{Integer.valueOf(line.split(" ")[0]), Integer.valueOf(line.split(" ")[1])});
        }

        requests.keySet().stream().sorted((a, b) -> {
            int startA = requests.get(a)[0];
            int startB = requests.get(b)[0];
            return startA < startB ? -1 : 1;
        }).forEach(request -> {

            boolean found = false;

            for (int cable : attributions.keySet()) {
                if (attributions.get(cable) == -1) {
                    attributions.replace(cable, request);
                    results.add(cable);

                    found = true;
                    break;
                }
            }

            if (!found) {

                int amount = attributions.size();
                int count = 0;

                for (int cable : attributions.keySet()) {

                    Integer[] reqChallenger = requests.get(request);
                    Integer[] reqOwner = requests.get(attributions.get(cable));

                    if (reqChallenger[0] > reqOwner[1]) {
                        attributions.replace(cable, request);
                        results.add(cable);
                        break;
                    }

                    count++;
                }

                if (count >= amount && results.size() < engineers) {
                    System.out.println("pas possible");
                    System.exit(0);
                }
            }
        });

        StringBuilder builder = new StringBuilder();

        requests.forEach((key, value) -> {
            builder.append(key).append(" : ").append(value[0]).append(" - ").append(value[1]).append("\n");
        });

        System.err.println(builder);
        System.out.println(results.stream().map(a -> String.valueOf(a)).reduce((a, b) -> a + " " + b).get());
    }
}
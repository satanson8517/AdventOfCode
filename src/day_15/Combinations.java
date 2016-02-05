package day_15;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 04/02/2016
 */
class Combinations {

    final List<int[]> ingreds;
    private Queue<int[]> combos;

    public Combinations(List<int[]> ingreds) {
        this.ingreds = ingreds;
        this.combos = new LinkedList<>();
    }

    void comboGen() {
        final int sum = 100;
        int[] combo = {1, 1, 1};

        try {
            while (combo[0] + combo[1] + combo[2] <= sum) {
                increment(combo, 2, combo[0] + combo[1], sum - (combo[0] + combo[1]));
//				System.out.println(combo[0] + ", " + combo[1]);
                System.out.println(combo[0] + ", " + combo[1] + ", " + combo[2]);
            }
        } catch (Exception e) {
        }
    }

    void increment(int[] combo, int pos, int min, int max) {
        if (combo[pos] == max) {
            combo[pos] = min;
            increment(combo, pos - 1, min, max);
        } else {
            combo[pos]++;
        }
    }

    int evaluate() {
        int total, subTotal;

        comboGen();

//		COMBOS:
//		for (int[] combo : combos) {
//			total = 1;
//			for (int i = 0; i < ingreds.get(0).props.length - 1; i++) {
//				subTotal = 1;
//
//				subTotal *= ingreds.get(0).props[i] * combo[0]
//						+ ingreds.get(1).props[i] * combo[1];
////						+ ingreds.get(2).props[i] * combo[2]
////						+ ingreds.get(3).props[i] * combo[3];
//
////				System.out.println(subTotal);
//				if (subTotal < 0) {
//					continue COMBOS;
////					subTotal = 0;
//				}
//				total *= subTotal;
//			}
//			System.out.println(total);
//		}
        return 0;
    }

    static void testGen() {
        int[] combo = {1, 1};
        int sumMax = 10,
                min = 1;
        
        print(combo);

        for (int pos = 0; pos < combo.length; pos++) {
            for (int value = min; value < sumMax - sumRest(combo, pos); value++) {
                combo[pos]++;
                print(combo);
            }
            if (pos + 1 < combo.length) {
                combo[pos] = 1;
                combo[pos + 1]++;
                min++;
            }
        }
    }

    private static int sumRest(int[] arr, int missPos) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i != missPos) {
                sum += arr[i];
            }
        }

        return sum;
    }

    private static void print(int[] combo) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < combo.length; i++) {
            sb.append(combo[i]).append(i == combo.length - 1 ? "" : ",");
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

}

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

    int evaluate() {
        int total, subTotal;

        return 0;
    }

    static void testGen() {
        int[] combo = {1, 1};
        int sumMax = 10,
                min = 1;

        print(combo);

        int pos = 0;
        int outer = 0, inner = 0;

//        for (int pos = 0; pos < combo.length - 1; pos++) {
            while (wellOrderedPos(combo, sumMax)) {
                outer++;
                for (int value = min; value <= sumMax - sumArr(combo, pos); value++) {
                    inner++;
                    combo[pos] = value;
                    print(combo);
                }
                if (pos + 1 < combo.length) {
                    min++;
                    combo[pos] = min;
                    combo[pos + 1]++;
                }
            }
//        }

        System.out.println("Outer: " + outer);
        System.out.println("Inner: " + inner);
    }
    
    static void testGenRec(){
        int[] combo = {1, 1};
        int sumMax = 10,
                min = 1;
        
        
        
    }
    
    private static void increment(int[] combo, int pos, int min, int max){
        if (sumArr(combo, -1) == max) {
            combo[pos] = ++min;
            increment(combo, pos - 1, min++, max);
        } else {
            combo[pos]++;
        }
    }

    private static boolean wellOrderedPos(int[] combo, int sumMax) {
        boolean result = true;

        for (int i = 0; i < combo.length - 1; i++) {
            if (combo[i] < combo[i + 1]
                    || combo[i] < 0
                    || sumArr(combo, -1) > sumMax) {
                result = false;
            }
        }

        return result;
    }

    /**
     * @param arr
     * @param missPos Position that should be omitted while adding. If you use
     * negative integer the cycle will sum all elements.
     * @return
     */
    private static int sumArr(int[] arr, int missPos) {
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

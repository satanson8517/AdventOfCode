package day_04;

import adventofcode.Day;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 16/12/2015
 */
public class Day04 implements Day {

    private static final String INPUT = "iwrupvqb";

    @Override
    public void run() throws Exception {
        int suffix = 1;
        String md5 = "";
//        while (!md5.matches("00000\\d.*")) {
        while (!md5.matches("000000\\d.*")) {
            md5 = MD5Encoder.encode(INPUT + suffix);
            if (suffix % 100000 == 0){
                System.out.println(suffix);
            }
            suffix++;
        }
        System.out.println(md5);
        System.out.println(--suffix);
    }
}

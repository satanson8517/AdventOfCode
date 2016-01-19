package day_04;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author michal.nedbalek
 */
class MD5Encoder {

    static String encode(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] encodedBytes = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedBytes.length; i++) {
            sb.append(Integer.toHexString((encodedBytes[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    // TESTING
//    public static void main(String[] args) {
//        try {
//            System.out.println(encode("sedaseda")); //5ca7777701d155824129d8f8dc90120b
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(MD5Encoder.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(MD5Encoder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}

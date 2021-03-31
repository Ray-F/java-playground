package nz.ac.aucklanduni.rfen629.algorithm;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Raymond Feng (rf.raymondfeng@gmail.com)
 */
public class ReverseKey {
    public final static String HMAC = "HmacSHA256";

    public static String encode(String key, String payload) {

        try {
            Mac hmac = Mac.getInstance(HMAC);
            hmac.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), HMAC));

            byte[] encoded = hmac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            System.out.println(new String(encoded));

            return new String(Base64.getUrlEncoder().encode(encoded));
        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }
    }

    public static String decode(String encrypted) {
        return new String(Base64.getUrlDecoder().decode(encrypted));
    }

    public static void main(String[] args) {
        String payload = """
                {
                  "_id": "6046c0a1596fd3004bbdb4f5",
                  "email": "rfen629@aucklanduni.ac.nz",
                  "activated": true,
                  "__v": 0,
                  "iat": 1617189194,
                  "exp": 1617448394
                }
                """;

        String key = "hello";

        System.out.println(decode(encode(key, payload)));

    }
}

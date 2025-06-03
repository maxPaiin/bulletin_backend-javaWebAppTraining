import org.example.util.JwtHelper;
import org.example.util.MD5Util;
import org.junit.Test;

public class testUserLogin {
    @Test
    public void TokenTest(){
        String token = JwtHelper.createToken(1L);
        System.out.println(token);

        Long userId = JwtHelper.getUserId(token);
        System.out.println(userId);

        System.out.println(JwtHelper.isExpiration(token));
    }
    @Test
    public void MD5Utiltest(){
        System.out.println(MD5Util.encrypt("123456"));
        System.out.println(MD5Util.encrypt("123456").length());
    }
}

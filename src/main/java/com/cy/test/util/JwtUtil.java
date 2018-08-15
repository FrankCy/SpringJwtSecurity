package com.cy.test.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: SpringJwtSecurity
 * @package: com.cy.test
 * @email: cy880708@163.com
 * @date: 2018/8/15 下午5:07
 * @mofified By:
 */
public class JwtUtil {

    /**
     * @description：密钥
     */
    private static final String secret = "bdjr_secret_key";

    /**
     * @description：根据制定规则生成Token
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/8/15 下午5:29
     * @mofified By:
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * @description：返回未来30天的时间
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/8/15 下午5:24
     * @mofified By:
     */
    public static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + 30L * 60L * 60L * 24L * 1000L);
    }

    /**
     * @description：揭密对象
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/8/15 下午5:32
     * @mofified By:
     */
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * @description：测试
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/8/15 下午5:27
     * @mofified By:
     */
    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap();
        claims.put("userId", "admin");
        claims.put("password", "123456");
        String token = generateToken(claims);
        System.out.println(token);
        Claims claimsObj = getClaimsFromToken(token);

        claimsObj.forEach((k,v)->{
            System.out.println("key : " + k + " <----------> val : " + v);
        });

    }
}
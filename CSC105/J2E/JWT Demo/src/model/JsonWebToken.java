package model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JsonWebToken {
    String secret;
    public JsonWebToken(){
        secret = "SomeSecretStringThatIsVeryLong";
    }

    public String createJWT(){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("csb")
                    .withClaim("userid", "0101")
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            exception.printStackTrace();
        }
        return null;
    }

    public boolean verifyJWT(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("csb")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            exception.printStackTrace();
        }
        return false;
    }
}

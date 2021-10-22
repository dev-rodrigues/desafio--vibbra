package com.vibbra.user.interactors;

import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class ValidateTokenUseCase {

    public boolean execute(String tokenJwt) {
        SignedJWT jwt;
        try {
            jwt = SignedJWT.parse(tokenJwt);
            var zip = jwt.getPayload().toJSONObject().get("zipCode");
            return zip != null;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}

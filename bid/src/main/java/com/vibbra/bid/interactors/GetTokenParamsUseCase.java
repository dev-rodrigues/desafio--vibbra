package com.vibbra.bid.interactors;

import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GetTokenParamsUseCase {

    public Map<String, Object> execute(String token) {
        var response = new HashMap<String, Object>();
        SignedJWT jwt;

        try {
            jwt = SignedJWT.parse(token);
            var json = jwt.getPayload().toJSONObject();
            var zip = (String) json.get("zipCode");
            var userId = (Long) json.get("userId");

            response.put("zipCode", zip);
            response.put("userId", userId);
            return response;
        } catch (ParseException ignored) {}

        return null;
    }
}

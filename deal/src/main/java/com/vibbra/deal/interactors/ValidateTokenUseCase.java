package com.vibbra.deal.interactors;

import com.google.common.base.Strings;
import com.vibbra.deal.expections.UserNotAuthorizedException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class ValidateTokenUseCase {

    public void execute(Map<String, Object> params) {
        if (Strings.isNullOrEmpty((String) params.get("zipCode"))) {
            throw new UserNotAuthorizedException("User not allowed");
        } else if (Objects.isNull(params.get("userId"))) {
            throw new UserNotAuthorizedException("User not allowed");
        }
    }
}

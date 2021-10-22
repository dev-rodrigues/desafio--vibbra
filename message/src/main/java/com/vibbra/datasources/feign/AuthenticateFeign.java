package com.vibbra.datasources.feign;

import com.vibbra.configs.FeignConfiguration;
import com.vibbra.datasources.feign.data.TokenRequest;
import com.vibbra.datasources.feign.data.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "authenticate", url ="${authenticate.host}", configuration = FeignConfiguration.class)
public interface AuthenticateFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenResponse authentication(@RequestBody TokenRequest tokenRequest);


}

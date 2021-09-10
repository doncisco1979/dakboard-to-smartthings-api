package com.FrankieRodriguez.dakboardtosmartthingsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.List;

public class TriviaProxy
{
    private static RestTemplate restTemplate;
    private static final String trivaHostURL = "http://jservice.io/api";

    public TriviaProxy(){
        restTemplate = new RestTemplate();
    }

    public TriviaProxyModel getRandomTrivia(){

        ResponseEntity<List<TriviaProxyModel>> responseEntity =
                restTemplate.exchange(trivaHostURL+"/random",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<TriviaProxyModel>>() {
                        });

        if(!responseEntity.getBody().isEmpty()){
            return responseEntity.getBody().get(0);
        }

        return null;
    }
}

package com.FrankieRodriguez.dakboardtosmartthingsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ToDoIstProxy
{
    private static RestTemplate restTemplate;
    private static final String trivaHostURL = "https://beta.todoist.com/API/v8";
    private static final String bearerToken = "8d6399ecb30154aec6ede72099b6e571dc26a416";

    public ToDoIstProxy(){
        restTemplate = new RestTemplate();

    }
    public List<TaskProxyModel> getTaskListByProject(Long projectId){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+bearerToken);
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);


        ResponseEntity<List<TaskProxyModel>> responseEntity =
                restTemplate.exchange(trivaHostURL+"/tasks?project_id=" + projectId,
                        HttpMethod.GET, entity, new ParameterizedTypeReference<List<TaskProxyModel>>() {
                        });

        if(!responseEntity.getBody().isEmpty()){
            return responseEntity.getBody();
        }

        return null;
    }

}

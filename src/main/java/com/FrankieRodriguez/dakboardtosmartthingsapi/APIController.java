package com.FrankieRodriguez.dakboardtosmartthingsapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController
{
    Logger logger = LoggerFactory.getLogger(APIController.class);
    private static TriviaService trivaService;
    private static ToDoIstProxy todoistProxy;
    public APIController(){

        trivaService = new TriviaService();
        todoistProxy = new ToDoIstProxy();
    }
    @GetMapping("/monitor/{state}")
    public ResponseEntity<Boolean> controlMonitor(@PathVariable Integer state){
        Boolean success = false;
        Process proc;
        try{
            if(state.equals(1) || state.equals(0)){
                String[] cmdArray = new String[6];
                //xrandr --output HDMI-1 --off --rotate right
                cmdArray[0] = "xrandr";
                cmdArray[1] = "--output";
                cmdArray[2] = "HDMI-1";
                cmdArray[3] = state == 1 ? "--auto" : "--off";
                cmdArray[4] = "--rotate";
                cmdArray[5] = "right";
                logger.debug("Command being run: {}", Arrays.asList(cmdArray));
                
                proc = Runtime.getRuntime().exec(cmdArray,null);
                
                success = true;
            }
        }
        catch(IOException e){
            logger.error("Failed to update Monitor Status:",e);
            return new ResponseEntity<>(success, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(success, HttpStatus.OK);

    }
    @GetMapping("/trivia")
    public ResponseEntity<TriviaObject> getTrivia(){

        return new ResponseEntity<>(trivaService.getRandomTriviaQuestion(), HttpStatus.OK);
    }
    @GetMapping("/todoist/tasks/{projectId}")
    public ResponseEntity<List<TaskProxyModel>> getToDoIstTaskList(@PathVariable Long projectId){
        return new ResponseEntity<List<TaskProxyModel>>(todoistProxy.getTaskListByProject(projectId), HttpStatus.OK);
    }
}

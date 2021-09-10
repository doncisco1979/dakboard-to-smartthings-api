package com.FrankieRodriguez.dakboardtosmartthingsapi;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController
{
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
                //ProcessBuilder pb = new ProcessBuilder("vcgencmd", "display_power", state.toString());
                //proc = pb.start();
                String[] cmdArray = new String[3];
                cmdArray[0] = "vcgencmd";
                cmdArray[1] = "display_power";
                cmdArray[2] = state.toString();
                proc = Runtime.getRuntime().exec(cmdArray,null);
                success = true;
            }
            /*else if(state.equals(0)){
                proc = Runtime.getRuntime().exec("vcgencmd display_power 0");
                success = true;

            }*/
        }
        catch(IOException e){
            //System.err.println("Failed to updated Monitor Status" + e.getStackTrace());
            System.err.println("Failed to update Monitor Status");
            e.printStackTrace();
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

package com.FrankieRodriguez.dakboardtosmartthingsapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app")
public class ApplicationController
{
    private ToDoIstProxy todoistProxy;
    public ApplicationController(){
        todoistProxy = new ToDoIstProxy();
    }
    @GetMapping("/greeting")
    public String test(Model model){
        model.addAttribute("resp","Hello World");
        return "greeting.html";
    }
    @GetMapping("/todoisttasks")
    public String todoistTasks(@RequestParam(name="projectId", required = true) Long projectId, Model model){
        model.addAttribute("tasks", todoistProxy.getTaskListByProject(projectId));
        return "todoist-todo-list.html";
    }

}

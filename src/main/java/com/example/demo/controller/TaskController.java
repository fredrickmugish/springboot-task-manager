package com.example.demo.controller;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller 
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // This method handles GET requests to "/tasks"
    @GetMapping("/tasks")
    public String showTasksPage(Model model) {
        // 1. Get all tasks from the repository
        List<Task> tasks = taskRepository.findAll();
        
        // 2. Add the list of tasks to the model so the view can access it
        model.addAttribute("tasks", tasks);
        
        // 3. Add an empty Task object to the model for the form
        model.addAttribute("newTask", new Task());
        
        // 4. Return the name of the HTML template to render
        return "tasks"; // This corresponds to "tasks.html"
    }

    // This method handles POST requests to "/tasks"
    @PostMapping("/tasks")
    public String createTask(@ModelAttribute Task task) {
        // 1. Save the new task that was created from the form data
        taskRepository.save(task);
        
        // 2. Redirect the user back to the "/tasks" page
        return "redirect:/tasks";
    }
}

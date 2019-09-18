package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.domein.Todo;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;

import javax.imageio.ImageIO;

@Controller
@RequestMapping("")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/")
    public String home(Model model) {
        return "todos/home";
    }

    @GetMapping("/todos")
    public String index(Model model) {
        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos); 
        return "/todos/upload";
    }

    @GetMapping("/todos/search")
    public String search_and_see_screen(Model model) {
      return "todos/search_and_see";
    }

    @PostMapping("/todos/search")
    public String search(Model model, @RequestParam String query) {
      List<Todo> todos = todoRepository.findTodosByName(query);
      model.addAttribute("todos", todos); 
      return "todos/search_and_see";
    }

    @GetMapping("/todos/new")
    public String newTodo(Model model) {
        return "todos/new";
    }

    @GetMapping("/todos/{id}/edit")
    public String edit(@PathVariable Long id, Model model) { 
        Todo todo = todoService.findOne(id);
        model.addAttribute("todo", todo);
        return "todos/edit";
    }

    @GetMapping("/todos/{id}")
    public String show(@PathVariable Long id, Model model) {
        Todo todo = todoService.findOne(id);
        model.addAttribute("todo", todo);
        return "todos/show";
    }

    @PostMapping("/todos/new")
    public String create(@ModelAttribute Todo todo) { 
        todoService.save(todo);
        return "redirect:/todos"; 
    }

    @PostMapping("/todos/{id}")
    public String done(@PathVariable Long id) {
        Todo todo = todoService.findOne(id);
        todo.setDone();
        todoService.save(todo);
        return "redirect:/todos";
    }

    @PutMapping("/todos/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoService.save(todo);
        return "redirect:/todos";
    }

    @PostMapping("/upload")
    public String handleFormUpload( @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            File destination = new File("/Users/miyoshisoya/j/mytodoapp/src/main/resources/stored/" + file.getOriginalFilename() + ".jpg"); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
            ImageIO.write(src, "jpg", destination);
            //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
        }
        return "redirect:/todos";
    }

    @DeleteMapping("/todos/{id}")
    public String destroy(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/todos";
    }
    
}

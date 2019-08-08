package com.example.demo.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.MessageSource;


import com.example.demo.domein.Todo;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;

@Controller
@RequestMapping("/todos") // ①
public class TodoController {
    @Autowired
    private TodoService todoService;

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    MessageSource msg;

    @GetMapping
    public String index(Model model) { // ②
        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos); // ③
        return "todos/index"; // ④
    }

    @GetMapping("new")
    public String newTodo(Model model) {
        return "todos/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        Todo todo = todoService.findOne(id);
        model.addAttribute("todo", todo);
        return "todos/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Todo todo = todoService.findOne(id);
        model.addAttribute("todo", todo);
        return "todos/show";
    }

    @PostMapping
    public String create(@ModelAttribute Todo todo) { // ⑥
        todoService.save(todo);
        return "redirect:/todos"; // ⑦
    }


    @PostMapping("{id}")
    public String done(@ModelAttribute Todo todo) {
        todo.setDone();
        todoService.save(todo);
        return "redirect:/todos";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoService.save(todo);
        return "redirect:/todos";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/todos";
    }

    /*
    
    @GetMapping("search")
    public String search(Model model, @RequestParam(defaultValue = "") String name) {
        List<Todo> tasks = todoService.findTodos(name);
        model.addAttribute("taskNumSearched", -1);
        if (name.equals("")) {
            return "search";
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskNumSearched", tasks.size());
        return "search";
    }*/


    /*
    @PostMapping("todos/search")
    public ModelAndView search(@RequestParam String keyword) {
    System.out.println(keyword);
    
    ModelAndView mv = new ModelAndView();
    
    mv.setViewName("/todos");
    if (keyword.length() > 0) {
        System.out.println(keyword);
        List<Todo> list = todoRepository.findTodos(keyword);
        if (CollectionUtils.isEmpty(list)) {
          String message = msg.getMessage("not found!", null,  Locale.JAPAN);
          mv.addObject("emptyMessage", message);
        }
        mv.addObject("list", list);
      }
      return mv;
    }*/
   
}

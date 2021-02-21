package ru.teapot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.teapot.dao.ClientDAO;
import ru.teapot.models.Client;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final ClientDAO clientDAO;

    @Autowired
    public PeopleController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", clientDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newClient(@ModelAttribute("client") Client client) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("client") @Valid Client client,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        clientDAO.save(client);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("client", clientDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";

        clientDAO.update(client);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        clientDAO.delete(id);
        return "redirect:/people";
    }
}
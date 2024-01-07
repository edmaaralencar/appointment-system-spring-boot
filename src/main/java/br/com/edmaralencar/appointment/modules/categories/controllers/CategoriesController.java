package br.com.edmaralencar.appointment.modules.categories.controllers;

import br.com.edmaralencar.appointment.modules.categories.entities.Category;
import br.com.edmaralencar.appointment.modules.categories.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping
    public List<Category> getCategories() {
        return this.categoriesRepository.findAll();
    }

    @GetMapping("/active")
    public List<Category> getActivesCategories() {
        return this.categoriesRepository.findAllActiveCategories();
    }

}

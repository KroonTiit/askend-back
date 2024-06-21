package com.example.askend;

import filter.FilterModelAssembler;
import filter.FilterRepository;
import filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class FilterController {

    private final FilterRepository repository;
    private final FilterModelAssembler assembler;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld()
    {
        return "Hello World!";
    }

    FilterController (FilterRepository repository, FilterModelAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }
    @GetMapping("/filters")
    public CollectionModel<EntityModel<Filter>> all() {

        List<EntityModel<Filter>> employees = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(FilterController.class).all()).withSelfRel());
    }
    @PostMapping("/filter")
    Filter newFilter(@RequestBody Filter newFilter) {
        return repository.save(newFilter);
    }

    @GetMapping("/filter/{id}")
    public Filter one(@PathVariable Long id) {
        Filter filter = repository.findById(id)
                .orElseThrow(() -> new FilterNotFoundException(id));
        return assembler.toModel(filter).getContent();
    }
    @PutMapping("/filters/{id}")
    Filter replacefilter(@RequestBody Filter newFilter, @PathVariable Long id) {
        return repository.findById(id)
                .map(filter -> {
                    filter.setName(newFilter.getName());
                    filter.setCriterias(newFilter.getCriterias());
                    return repository.save(filter);
                })
                .orElseGet(() -> {
                    return repository.save(newFilter);
                });
    }
    @DeleteMapping("/filters/{id}")
    void deleteFilter(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
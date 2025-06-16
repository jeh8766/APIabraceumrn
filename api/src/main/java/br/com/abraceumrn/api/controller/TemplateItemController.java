package br.com.abraceumrn.api.controller;

import br.com.abraceumrn.api.service.TemplateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.abraceumrn.api.model.TemplateItem;
import br.com.abraceumrn.api.repository.TemplateItemRepository;

@RestController
public class TemplateItemController {

    private final TemplateItemService templateItemService;
    
    @Autowired
    private TemplateItemRepository action;


    TemplateItemController(TemplateItemService templateItemService) {
        this.templateItemService = templateItemService;
    }

    
     @PostMapping("/templateitem")
    public TemplateItem register(@RequestBody TemplateItem templateItem){
        return action.save(templateItem);
    }

    @GetMapping("/templateitem")
    public ResponseEntity<?> listar(){
        return templateItemService.listar(null);
    }

    @GetMapping("/templateitem/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        return templateItemService.listarPorId(id);
    }

    @PutMapping("/templateitem")
    public TemplateItem atualizar(@RequestBody TemplateItem templateItem){
        return action.save(templateItem);
    }
    @DeleteMapping("/templateitem/{id}")
    public void remove(@PathVariable Long id) {
        action.deleteById(id);
    }

    @GetMapping("/templateitem/count")
    public long count(){
        return action.count();
    }
}

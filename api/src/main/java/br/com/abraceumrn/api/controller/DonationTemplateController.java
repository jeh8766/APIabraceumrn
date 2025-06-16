package br.com.abraceumrn.api.controller;

import br.com.abraceumrn.api.service.DonationTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.abraceumrn.api.model.DonationTemplate;
import br.com.abraceumrn.api.repository.DonationTemplateRepository;

@RestController
public class DonationTemplateController {

    private final DonationTemplateService donationTemplateService;
    
    @Autowired
    private DonationTemplateRepository action;


    DonationTemplateController(DonationTemplateService donationTemplateService) {
        this.donationTemplateService = donationTemplateService;
    }

    
     @PostMapping("/donationtemplate")
    public DonationTemplate register(@RequestBody DonationTemplate donationTemplate){
        return action.save(donationTemplate);
    }

    @GetMapping("/donationtemplate")
    public ResponseEntity<?> listar(){
        return donationTemplateService.listar(null);
    }

    @GetMapping("/donationtemplate/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        return donationTemplateService.listarPorId(id);
    }

    @PutMapping("/donationtemplate")
    public DonationTemplate atualizar(@RequestBody DonationTemplate donationTemplate){
        return action.save(donationTemplate);
    }

    @DeleteMapping("/donationtemplate/{id}")
    public void remove(@PathVariable Long id) {
        action.deleteById(id);
    }

    @GetMapping("/donationtemplate/count")
    public long count(){
        return action.count();
    }
}

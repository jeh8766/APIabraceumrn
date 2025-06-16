package br.com.abraceumrn.api.controller;

import br.com.abraceumrn.api.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.abraceumrn.api.model.Donation;
import br.com.abraceumrn.api.repository.DonationRepository;

@RestController
public class DonationController {

    private final DonationService donationService;
    
    @Autowired
    private DonationRepository action;

    DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

     @PostMapping("/donation")
    public Donation register(@RequestBody Donation donation){
        return action.save(donation);
    }

    @GetMapping("/donation")
    public ResponseEntity<?> listar(){
        return donationService.listar(null);
    }

    @GetMapping("/donation/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        return donationService.listarPorId(id);
    }

    @PutMapping("/donation")
    public Donation atualizar(@RequestBody Donation donation){
        return action.save(donation);
    }

    @DeleteMapping("/donation/{id}")
    public void remove(@PathVariable Long id) {
        action.deleteById(id);
    }

    @GetMapping("/donation/count")
    public long count(){
        return action.count();
    }
}

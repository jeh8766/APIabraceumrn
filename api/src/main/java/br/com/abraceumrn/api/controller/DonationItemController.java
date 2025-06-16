package br.com.abraceumrn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.abraceumrn.api.model.DonationItem;
import br.com.abraceumrn.api.repository.DonationItemRepository;
import br.com.abraceumrn.api.service.DonationItemService;

@RestController
public class DonationItemController {
    @Autowired
    private DonationItemRepository action;
    @Autowired
    private DonationItemService donationItemService;

    @PostMapping("/donationitem")
    public ResponseEntity<?> register(@RequestBody DonationItem donationItem){
        return donationItemService.register(donationItem);
    }

    @GetMapping("/donationitem")
    public ResponseEntity<?> listar(){
        return donationItemService.listar(null);
    }

    @GetMapping("/donationitem/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        return donationItemService.listarPorId(id);
    }

    @PutMapping("/donationitem")
    public DonationItem atualizar(@RequestBody DonationItem donationItem){
        return action.save(donationItem);
    }

    @DeleteMapping("/donationitem/{id}")
    public void remove(@PathVariable Long id) {
        action.deleteById(id);
    }

    @GetMapping("/donationitem/count")
    public long count(){
        return action.count();
    }
}

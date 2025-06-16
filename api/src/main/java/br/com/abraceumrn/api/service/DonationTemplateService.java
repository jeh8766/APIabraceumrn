package br.com.abraceumrn.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.abraceumrn.api.model.DonationTemplate;
import br.com.abraceumrn.api.model.Message;
import br.com.abraceumrn.api.repository.DonationTemplateRepository;

@Service
public class DonationTemplateService {
    
    @Autowired
    private Message message;

    @Autowired
      private DonationTemplateRepository action;

    public ResponseEntity<?> listar(DonationTemplate donationTemplate){
         return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorId(long id){
      if(action.countById(id)==0){
        message.setMessage("Código inválido.");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
      } else{
        return new ResponseEntity<>(action.findById(id), HttpStatus.OK);
      }
    }
  }





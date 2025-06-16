package br.com.abraceumrn.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.abraceumrn.api.model.DonationItem;
import br.com.abraceumrn.api.model.Message;
import br.com.abraceumrn.api.repository.DonationItemRepository;
import br.com.abraceumrn.utils.UnitOfMetrics;

@Service
public class DonationItemService {

   @Autowired
   private Message message;

   @Autowired
   private DonationItemRepository action;

   public ResponseEntity<?> register(DonationItem donationItem){

      if (donationItem.getDescricao().equals("")){
         message.setMessage("A descrição precisa ser preenchida!");
         return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
      }else if(donationItem.getQuantidade() <= 0){
         message.setMessage("Informe uma quantidade válida!");
         return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
      }else if(donationItem.getUnidadeMedida() == null){
         donationItem.setUnidadeMedida(UnitOfMetrics.GRAMAS);
         return new ResponseEntity<>(HttpStatus.OK);
      }
      else{
         action.save(donationItem);
         return new ResponseEntity<>(action.save(donationItem), HttpStatus.CREATED);
      }
   }

   public ResponseEntity<?> listar(DonationItem donationItem){
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



    //public List<DonationItem> listAll(){
      //  lista = DonationItemRepository.listAll();
      //  return lista;
   // }
}

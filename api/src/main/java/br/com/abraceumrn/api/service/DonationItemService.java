package br.com.abraceumrn.api.service;

import org.springframework.data.geo.Metric;
import org.springframework.stereotype.Service;

import br.com.abraceumrn.api.repository.DonationItemRepository;

@Service
public class DonationItemService {
    public Boolean CriarDonation(String tipo, String descricao, Metric unidadeMedida, double quantidade){
       return false;
    }
    public List<DonationItem> listAll(){
        lista = DonationItemRepository.listAll();
        return lista;
    }
}

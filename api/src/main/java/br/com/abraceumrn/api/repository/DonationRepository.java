package br.com.abraceumrn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.abraceumrn.api.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{
    
}

package br.com.abraceumrn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.abraceumrn.api.model.DonationItem;

public interface DonationItemRepository extends JpaRepository<DonationItem, Long>{
    long countById(Long id);
}
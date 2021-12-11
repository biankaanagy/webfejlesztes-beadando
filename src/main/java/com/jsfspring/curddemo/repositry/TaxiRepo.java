package com.jsfspring.curddemo.repositry;

import com.jsfspring.curddemo.entity.TaxiDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepo extends JpaRepository<TaxiDTO, Long> {

	TaxiDTO findTitleByTaxiName(String taxiName);
}
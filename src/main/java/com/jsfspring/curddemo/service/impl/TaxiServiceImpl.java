/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jsfspring.curddemo.entity.TaxiDTO;
import com.jsfspring.curddemo.repositry.TaxiRepo;
import com.jsfspring.curddemo.service.TaxiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.uito.TaxiUITO;

@Service
@Transactional
public class TaxiServiceImpl implements TaxiService {
	@Autowired
	private TaxiRepo taxiRepo;

	@Override
	public List<TaxiUITO> getAllTaxi() {
		List<TaxiUITO> taxiUITOLst = new ArrayList<>();
		List<TaxiDTO> taxiDTOLst = taxiRepo.findAll();

		taxiDTOLst.forEach(dto -> {
			TaxiUITO tmpUiTO = new TaxiUITO();

			BeanUtils.copyProperties(dto, tmpUiTO);
			taxiUITOLst.add(tmpUiTO);
		});

		return taxiUITOLst;
	}

	@Override
	public TaxiUITO getTaxi(TaxiUITO taxiUITO) {
		System.out.println(">>>>> "+taxiUITO.getTaxiName());
		TaxiDTO dto = taxiRepo.findTitleByTaxiName(taxiUITO.getTaxiName());
		TaxiUITO uito = new TaxiUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}
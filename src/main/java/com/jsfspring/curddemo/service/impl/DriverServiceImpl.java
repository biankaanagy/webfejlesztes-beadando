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

import com.jsfspring.curddemo.entity.DriverDTO;
import com.jsfspring.curddemo.entity.TaxiDTO;
import com.jsfspring.curddemo.repositry.DriverRepo;
import com.jsfspring.curddemo.service.DriverService;
import com.jsfspring.curddemo.uito.DriverUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.uito.TaxiUITO;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
	@Autowired
	DriverRepo driverRepo;

	@Override
	@Transactional(readOnly = false)
	public DriverUITO doSaveDriver(DriverUITO driverUiTO) {
		DriverDTO dto = UiToToDto(driverUiTO);
		dto = driverRepo.save(dto);
		BeanUtils.copyProperties(dto, driverUiTO);

		dtoToUito(driverUiTO, dto);
		return driverUiTO;
	}

	private void dtoToUito(DriverUITO driverUiTO, DriverDTO dto) {
		TaxiUITO uitTO = new TaxiUITO();
		BeanUtils.copyProperties(dto.getTaxiDTO(), uitTO);
		driverUiTO.setTaxiUITO(uitTO);
	}

	private DriverDTO UiToToDto(DriverUITO driverUiTO) {
		DriverDTO dto = new DriverDTO();
		TaxiDTO taxiDto = new TaxiDTO();
		BeanUtils.copyProperties(driverUiTO, dto);
		BeanUtils.copyProperties(driverUiTO.getTaxiUITO(), taxiDto);
		dto.setTaxiDTO(taxiDto);
		List<DriverDTO> lst = new ArrayList<>();
		lst.add(dto);
		taxiDto.getDrivertolst().addAll(lst);
		return dto;
	}

	@Override
	public List<DriverUITO> doFetchAllDriver() {
		List<DriverDTO> dtoLst = driverRepo.findAll();
		List<DriverUITO> uiTOLst = new ArrayList<>();
		dtoLst.forEach(dto -> {
			DriverUITO tmpUiTO = new DriverUITO();
			System.out.println(dto.getTaxiDTO());
			BeanUtils.copyProperties(dto, tmpUiTO);

			dtoToUito(tmpUiTO, dto);
			uiTOLst.add(tmpUiTO);
		});
		return uiTOLst;
	}

	@Override
	public DriverUITO doGetDriver(DriverUITO driverUiTO) {
		if (null != driverUiTO.getEmailId()) {
			DriverDTO dto = new DriverDTO();

			BeanUtils.copyProperties(driverUiTO, dto);
			dto = driverRepo.getOne(dto.getDriverId());

			BeanUtils.copyProperties(dto, driverUiTO);
		}
		return driverUiTO;
	}

	@Override
	@Transactional
	public void doDeleteDriver(DriverUITO driverUiTO) {
		driverRepo.deleteById(driverUiTO.getDriverId());
	}

}
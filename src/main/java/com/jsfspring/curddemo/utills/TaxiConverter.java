package com.jsfspring.curddemo.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.jsfspring.curddemo.service.TaxiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.curddemo.uito.TaxiUITO;

@Service
public class TaxiConverter implements Converter {

	@Autowired
	private TaxiService taxiService;

	private static final Logger LOG = LoggerFactory.getLogger(TaxiConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		LOG.info("getAsObject: " + taxiService);

		TaxiUITO departmentUITO = new TaxiUITO();
		departmentUITO.setTaxiName(string);
		departmentUITO = taxiService.getTaxi(departmentUITO);
		System.out.println(departmentUITO.toString());
		return departmentUITO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		LOG.info("getAsString obj class: " + obj.getClass().getName());
		if (obj instanceof TaxiUITO) {
			TaxiUITO dept = (TaxiUITO) obj;
			LOG.info("getAsString def name: " + dept.getTaxiName());
			return dept.getTaxiName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of TaxiUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}
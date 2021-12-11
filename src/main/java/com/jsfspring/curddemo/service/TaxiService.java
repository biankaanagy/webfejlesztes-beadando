
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.TaxiUITO;

public interface TaxiService {

	List<TaxiUITO> getAllTaxi();

	TaxiUITO getTaxi(TaxiUITO taxiUITO);

}
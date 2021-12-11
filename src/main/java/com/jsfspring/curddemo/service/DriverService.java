
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.DriverUITO;

public interface DriverService {
	DriverUITO doSaveDriver(DriverUITO driverUiTO);

	List<DriverUITO> doFetchAllDriver();

	DriverUITO doGetDriver(DriverUITO driverUiTO);

	void doDeleteDriver(DriverUITO driverUiTO);
}
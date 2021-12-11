/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import com.jsfspring.curddemo.service.DriverService;
import com.jsfspring.curddemo.service.TaxiService;
import com.jsfspring.curddemo.uito.DriverUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.curddemo.uito.TaxiUITO;

@Controller("driverController")
@SessionScope
public class DriverController {
	@Autowired
	private DriverService driverService;

	@Autowired
	private TaxiService taxiService;

	private String actionLabel;
	private DriverUITO driverUiTO;
	private List<DriverUITO> driverUiToList;

	private List<TaxiUITO> departmentUiToList;

	public void doSaveInfoDriver() {
		System.out.println(this.getDriverUiTO());
		driverService.doSaveDriver(this.getDriverUiTO());
		getAllDriver();
		this.setDriverUiTO(new DriverUITO());
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Driver Details", "Driver Details added/Updated Successfully."));
	}

	@PostConstruct
	public void getAllDriver() {
		if (!this.getDriverUiToList().isEmpty()) {
			this.getDriverUiToList().clear();
			this.getTaxiUiToList().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + driverService);
		this.getDriverUiToList().addAll(driverService.doFetchAllDriver());
		this.getTaxiUiToList().addAll(taxiService.getAllTaxi());
		this.setActionLabel("Add");
	}

	/**
	 * Remove selected Employee info
	 * 
	 * @return
	 */

	public void deleteDriver(DriverUITO driverUiTO) {
		driverService.doDeleteDriver(driverUiTO);
		getAllDriver();
	}

	public void editDriver(DriverUITO driverUiTO) {
		this.setActionLabel("Update");
		BeanUtils.copyProperties(driverUiTO, this.getDriverUiTO());
		System.out.println(this.getDriverUiTO());
	}

	public DriverUITO getDriverUiTO() {
		if (driverUiTO == null) {
			driverUiTO = new DriverUITO();
		}
		return driverUiTO;
	}

	public void setDriverUiTO(DriverUITO empUiTO) {
		this.driverUiTO = driverUiTO;
	}

	public List<DriverUITO> getDriverUiToList() {
		if (null == driverUiToList) {
			driverUiToList = new ArrayList<>();
		}
		return driverUiToList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public List<TaxiUITO> getTaxiUiToList() {
		if (departmentUiToList == null) {
			departmentUiToList = new ArrayList<>();
		}
		return departmentUiToList;
	}

	public void setDepartmentUiToList(List<TaxiUITO> departmentUiToList) {
		this.departmentUiToList = departmentUiToList;
	}
}
/**
 * 
 */
package com.jsfspring.curddemo.uito;

import java.io.Serializable;

public class DriverUITO implements Serializable {

	private static final long serialVersionUID = 4840260415183676656L;
	private Long driverId;
	private String driverName;
	private String password;
	private String address1;
	private String emailId;
	private TaxiUITO taxiUITO;

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public TaxiUITO getTaxiUITO() {
		return taxiUITO;
	}

	public void setTaxiUITO(TaxiUITO departmentUITO) {
		this.taxiUITO = departmentUITO;
	}

	@Override
	public String toString() {
		return "DriverUITO{" +
				"driverId=" + driverId +
				", driverName='" + driverName + '\'' +
				", password='" + password + '\'' +
				", address1='" + address1 + '\'' +
				", emailId='" + emailId + '\'' +
				", taxiUITO=" + taxiUITO +
				'}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DriverUITO other = (DriverUITO) obj;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		return true;
	}

}

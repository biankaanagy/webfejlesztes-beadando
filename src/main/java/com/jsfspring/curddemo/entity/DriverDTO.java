/**
 * 
 */
package com.jsfspring.curddemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "DRIVER_INFO")
@NamedQuery(name = "DriverDTO.findAll", query = "SELECT a FROM DriverDTO a")
public class DriverDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long driverId;
	@Column(name = "DRIVER_NAME", nullable = false)
	private String driverName;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	private String address1;
	@Column(name = "EMAIL_ID")
	private String emailId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAXI_ID")
	private TaxiDTO taxiDTO;

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

	public TaxiDTO getTaxiDTO() {
		return taxiDTO;
	}

	public void setTaxiDTO(TaxiDTO taxiDTO) {
		this.taxiDTO = taxiDTO;
	}
}

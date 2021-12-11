package com.jsfspring.curddemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "TAXI_MASTER")
public class TaxiDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TAXI_ID")
	private Long taxiId;
	@Column(name = "Taxi_Name")
	private String taxiName;

	@OneToMany(mappedBy = "taxiDTO")
	private List<DriverDTO> drivertolst;

	public Long getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(Long taxiId) {
		this.taxiId = taxiId;
	}

	public String getTaxiName() {
		return taxiName;
	}

	public void setTaxiName(String taxiName) {
		this.taxiName = taxiName;
	}

	public List<DriverDTO> getDrivertolst() {
		if (null == drivertolst) {
			drivertolst = new ArrayList<>();
		}
		return drivertolst;
	}

	public void setDrivertolst(List<DriverDTO> drivertolst) {
		this.drivertolst = drivertolst;
	}
}

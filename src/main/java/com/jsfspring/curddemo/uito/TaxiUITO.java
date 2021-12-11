package com.jsfspring.curddemo.uito;

import java.io.Serializable;
import java.util.List;

public class TaxiUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long taxiId;
	private String taxiName;
	private List<TaxiUITO> taxiUITOLst;

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

	public List<TaxiUITO> getTaxiUITOLst() {
		return taxiUITOLst;
	}

	public void setTaxiUITOLst(List<TaxiUITO> taxiUITOLst) {
		this.taxiUITOLst = taxiUITOLst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taxiId == null) ? 0 : taxiId.hashCode());
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
		TaxiUITO other = (TaxiUITO) obj;
		if (taxiId == null) {
			if (other.taxiId != null)
				return false;
		} else if (!taxiId.equals(other.taxiId))
			return false;
		return true;
	}

}

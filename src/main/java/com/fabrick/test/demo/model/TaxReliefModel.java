package com.fabrick.test.demo.model;

public class TaxReliefModel {

	private boolean isCondoUpgrade;
	private String creditorFiscalCode;
	private String taxReliefId;
	private String beneficiaryType;
	private NaturalPersonBeneficiaryModel naturalPersonBeneficiary;
	
	public boolean isCondoUpgrade() {
		return isCondoUpgrade;
	}
	public void setCondoUpgrade(boolean isCondoUpgrade) {
		this.isCondoUpgrade = isCondoUpgrade;
	}
	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}
	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}
	public String getTaxReliefId() {
		return taxReliefId;
	}
	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}
	public String getBeneficiaryType() {
		return beneficiaryType;
	}
	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}
	public NaturalPersonBeneficiaryModel getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}
	public void setNaturalPersonBeneficiary(NaturalPersonBeneficiaryModel naturalPersonBeneficiary) {
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
	}
	@Override
	public String toString() {
		return "TaxReliefModel [isCondoUpgrade=" + isCondoUpgrade + ", creditorFiscalCode=" + creditorFiscalCode
				+ ", taxReliefId=" + taxReliefId + ", beneficiaryType=" + beneficiaryType
				+ ", naturalPersonBeneficiary=" + naturalPersonBeneficiary + "]";
	}

}

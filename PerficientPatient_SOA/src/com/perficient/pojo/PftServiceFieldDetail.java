package com.perficient.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PFT_SERVICE_FIELD_DETAIL")
public class PftServiceFieldDetail {

	/*@Id
	@Column(name="PSFD_SERVICE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name="PSFD_SERVICE_ID", unique=true, nullable=false)
	 * //@GenericGenerator(name="gen", strategy77="foreign", parameters=@Parameter(name="property", value="pftServiceFieldDetail"))*/
	@Id
	@Column(name="PSFD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="PSFD_SERVICE_ID")
	private int serviceId;
	
	@Column(name="PSFD_FIELD_NAME")
	private String fieldName;
	
	//@Column(name="PSFD_FIELD_TYPE")
	//private String fieldType;
	
	@Column(name="PSFD_REGULAR_EXPRESSION")
	private String fieldExpression;
	
	@Column(name="PSFD_FIELD_MANDATORY")
	private String fieldMandatory;
	
	@Column(name="PSFD_ERROR_CODE")
	private String errorCode;
	
	
	
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@OneToMany(mappedBy="pftServiceFieldDetail")
	private Set<PftServiceDetails> pftServiceDetails;
	
	
	public Set<PftServiceDetails> getPftServiceDetails() {
		return pftServiceDetails;
	}

	public void setPftServiceDetails(Set<PftServiceDetails> pftServiceDetails) {
		this.pftServiceDetails = pftServiceDetails;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

/*	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}*/

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

/*	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}*/

	public String getFieldExpression() {
		return fieldExpression;
	}

	public void setFieldExpression(String fieldExpression) {
		this.fieldExpression = fieldExpression;
	}

	public String getFieldMandatory() {
		return fieldMandatory;
	}

	public void setFieldMandatory(String fieldMandatory) {
		this.fieldMandatory = fieldMandatory;
	}
	
	
	
}

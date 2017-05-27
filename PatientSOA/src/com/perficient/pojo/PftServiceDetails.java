package com.perficient.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PFT_SERVICE_DETAILS")
public class PftServiceDetails {

	@Id
	@Column(name="PSD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="PSD_SERVICE_ID")
	private int serviceId;
	
	@Column(name="PSD_SERVICE_NAME")
	private String serviceName;
	
	//@Column(name="PSD_SERVICE_HASHKEY")
	//private String hashKey;

	/*@OneToMany(fetch=FetchType.EAGER, targetEntity=PftServiceFieldDetail.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "PSD_SERVICE_ID", referencedColumnName="PSFD_SERVICE_ID")
	private Set<PftServiceFieldDetail> pftServiceFieldDetail = new HashSet<PftServiceFieldDetail>();
*/	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="PSFD_SERVICE_ID")
	private Set<PftServiceFieldDetail> pftServiceFieldDetail;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/*public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}
*/	
	/*@JoinColumn
	@OneToMany(fetch = FetchType.LAZY,mappedBy="PSFD_SERVICE_ID")*/
	public Set<PftServiceFieldDetail> getPftServiceFieldDetail() {
		return pftServiceFieldDetail;
	}

	public void setPftServiceFieldDetail(
			Set<PftServiceFieldDetail> pftServiceFieldDetail) {
		this.pftServiceFieldDetail = pftServiceFieldDetail;
	}
}

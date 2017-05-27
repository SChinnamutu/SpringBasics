package com.perficient.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PFT_USER_DETAILS")
public class PftUserDetails {

		@Id
		@Column(name="PUD_USER_ID")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int userId;
		
		/*@Id
		@Column(name="PUD_USER_ID")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private BigDecimal userId;*/
		
		@Column(name="PUD_PASSWORD")
		private String password;
		
		@Column(name="PUD_MOBILE_NUMBER")
		private String mobileNumber;
		
		@Column(name="PUD_EMAIL")
		private String email;
		
		@Column(name="PUD_USER_NAME")
		private String name;
		
		@Column(name="PUD_LAN_ID")
		private String lanId;
		
		/*private Set<PftAccountDetails> iPpiAccoutDetails =  new HashSet<PftAccountDetails>();*/
		
		
		public String getLanId() {
			return lanId;
		}

		public void setLanId(String lanId) {
			this.lanId = lanId;
		}

		/*public BigDecimal getUserId() {
			return userId;
		}

		public void setUserId(BigDecimal userId) {
			this.userId = userId;
		}*/
		public String getName() {
			return name;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		/*@OneToOne
		@JoinColumn(name="PAD_USER_ID")
		public Set<PftAccountDetails> getiPpiAccoutDetails() {
			return iPpiAccoutDetails;
		}

		public void setiPpiAccoutDetails(Set<PftAccountDetails> iPpiAccoutDetails) {
			this.iPpiAccoutDetails = iPpiAccoutDetails;
		}*/


		
		/*@Override
		public String toString(){
			return "id="+id+", name="+name+", country="+country;
		}
*/		
}

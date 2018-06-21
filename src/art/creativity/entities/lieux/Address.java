package art.creativity.entities.lieux;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6567055287642254816L;
	private Long place_id;
	private String licence;
	private String osm_type;
	private Long osm_id;
	private Double lat;
	private Double lon;
	private String display_name;
	private address address;
	private Double[] boundingbox;
			
	public Address() {
		super();
	}

	public Long getPlace_id() {
		return place_id;
	}




	public void setPlace_id(Long place_id) {
		this.place_id = place_id;
	}




	public String getLicence() {
		return licence;
	}




	public void setLicence(String licence) {
		this.licence = licence;
	}




	public String getOsm_type() {
		return osm_type;
	}




	public void setOsm_type(String osm_type) {
		this.osm_type = osm_type;
	}




	public Long getOsm_id() {
		return osm_id;
	}




	public void setOsm_id(Long osm_id) {
		this.osm_id = osm_id;
	}




	public Double getLat() {
		return lat;
	}




	public void setLat(Double lat) {
		this.lat = lat;
	}




	public Double getLon() {
		return lon;
	}




	public void setLon(Double lon) {
		this.lon = lon;
	}




	public String getDisplay_name() {
		return display_name;
	}




	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}




	public address getAddress() {
		return address;
	}




	public void setAddress(address address) {
		this.address = address;
	}




	public Double[] getBoundingbox() {
		return boundingbox;
	}

	public void setBoundingbox(Double[] boundingbox) {
		this.boundingbox = boundingbox;
	}




	public class address implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3925440051423725415L;
		private String neighbourhood;
		private String suburb;
		private String town;
		private String county;
		private String state;
		private String country;
		private String country_code;
		
		public address(){
			
		}
		public String getNeighbourhood() {
			return neighbourhood;
		}
		public void setNeighbourhood(String neighbourhood) {
			this.neighbourhood = neighbourhood;
		}
		public String getSuburb() {
			return suburb;
		}
		public void setSuburb(String suburb) {
			this.suburb = suburb;
		}
		public String getTown() {
			return town;
		}
		public void setTown(String town) {
			this.town = town;
		}
		public String getCounty() {
			return county;
		}
		public void setCounty(String county) {
			this.county = county;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCountry_code() {
			return country_code;
		}
		public void setCountry_code(String country_code) {
			this.country_code = country_code;
		}
		
	}
}

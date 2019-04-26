package br.com.cast.people.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * People
 */
@Entity
@Table(name="peoples")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long  id;

    @Column(name = "NAME")
	private String name;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "NUMBER")
	private Integer number;
	
	@Column(name = "NEIGHBORHOOD")
	private String neighborhood;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "CELLPHONE")
	private String cellphone;
	
	@Column(name = "PHONE")
	private String phone;

    public People(){

    }

    /**
     * Get id of People
     * @return int
     */
    public Long getId() {
		return id;
	}

    /**
     * Set id of People
     * @param id
     */
	public void setId(Long id) {
		this.id = id;
	}
    
    /**
     * Get Name of People
     * @return String
     */
	public String getName() {
		return name;
	}

    /**
     * Set name of People
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * Get Street of People
     * @return String
     */
	public String getStreet() {
		return street;
	}

    /**
     * Set Street of People
     * @param street
     */
	public void setStreet(String street) {
		this.street = street;
	}

    /**
     * Get Number of People
     * @return String
     */
	public Integer getNumber() {
		return number;
	}

    /**
     * Set number of People
     * @param number
     */
	public void setNumber(Integer number) {
		this.number = number;
	}

    /**
     * Get Neighborhood of People
     * @return String
     */
	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
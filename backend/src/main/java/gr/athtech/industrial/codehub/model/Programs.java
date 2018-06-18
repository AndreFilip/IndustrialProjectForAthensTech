package gr.athtech.industrial.codehub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
*
* @author Panagiotis Kourempanas
*/

@Entity
@Table(name = "programs")
public class Programs implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
    @Column(name = "programTitle", nullable = false)
    private String programTitle;
    
    @Column(name = "price")
    private String price;
    
    @Column(name = "smallDescription")
    private String smallDescription;
    
    @Column(name = "mainDescription")
    private String mainDescription;
    
    @Column(name = "additionalInfo")
    private String additionalInfo;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "programLogo")
    private String programLogo;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "programs")
    private Set<CodeHubUser> users;
    
    public Programs() {
    }

	public Programs(String programTitle, String price, String smallDescription, String mainDescription,
			String additionalInfo, String category, String programLogo) {
		super();
		this.programTitle = programTitle;
		this.price = price;
		this.smallDescription = smallDescription;
		this.mainDescription = mainDescription;
		this.additionalInfo = additionalInfo;
		this.category = category;
		this.programLogo = programLogo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProgramTitle() {
		return programTitle;
	}

	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSmallDescription() {
		return smallDescription;
	}

	public void setSmallDescription(String smallDescription) {
		this.smallDescription = smallDescription;
	}

	public String getMainDescription() {
		return mainDescription;
	}

	public void setMainDescription(String mainDescription) {
		this.mainDescription = mainDescription;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProgramLogo() {
		return programLogo;
	}

	public void setProgramLogo(String programLogo) {
		this.programLogo = programLogo;
	}

	public Set<CodeHubUser> getUsers() {
		return users;
	}

	public void setUsers(Set<CodeHubUser> users) {
		this.users = users;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Programs)) return false;
        Programs programs = (Programs) o;
        return Objects.equal(getId(), programs.getId()) &&
        		 Objects.equal(getProgramTitle(), programs.getProgramTitle()) &&
        		 Objects.equal(getPrice(), programs.getPrice()) &&
        		 Objects.equal(getSmallDescription(), programs.getSmallDescription()) &&
        		 Objects.equal(getMainDescription(), programs.getMainDescription()) &&
        		 Objects.equal(getAdditionalInfo(), programs.getAdditionalInfo()) &&
        		 Objects.equal(getCategory(), programs.getCategory()) &&
        		 Objects.equal(getProgramLogo(), programs.getProgramLogo()) &&
        		 Objects.equal(getUsers(), programs.getUsers());
	}
	 
	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getProgramTitle(), getPrice(), getSmallDescription(), getMainDescription(), 
			   getAdditionalInfo(), getCategory(), getProgramLogo());
	    }
	
	@Override
	public String toString() {
		return "Programs [id=" + id + ", programTitle=" + programTitle + ", price=" + price + ", smallDescription=" 
				+ smallDescription + ", mainDescription=" + mainDescription + ", additionalInfo=" + additionalInfo 
				+ ", category=" + category + ", programLogo=" + programLogo + "]";
	}
}
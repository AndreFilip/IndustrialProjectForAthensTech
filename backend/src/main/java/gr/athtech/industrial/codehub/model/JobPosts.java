package gr.athtech.industrial.codehub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author George Lalas
 * @edit Panagiotis Kourempanas
 */
@Entity
@Table(name = "job_posts")
public class JobPosts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;

    @Column(name = "location")
    private String location;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @Column(name = "jobDescription")
    private String description;

    @Column(name = "companyTitle")
    private String companyTitle;
    
    @Column(name = "companyDescription")
    private String companyDescription;
    
    @Column(name = "qualifications")
    private String qualifications;
    
    @Column(name = "companyLogo")
    private String companyLogo;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobPosts")
    private Set<CodeHubUser> users;

    public JobPosts() {
    }
    

  /**  public JobPosts(String jobTitle, String location, String description) {
        this.jobTitle = jobTitle;
        this.location = location;
        this.dateCreated = new Date();
        this.description = description;
    }
*/
    public JobPosts(String jobTitle, String location, String description, String companyTitle, String companyDescription,
			String qualifications, String companyLogo) {
		this.jobTitle = jobTitle;
		this.location = location;
        this.dateCreated = new Date();
		this.description = description;
		this.companyTitle = companyTitle;
		this.companyDescription = companyDescription;
		this.qualifications = qualifications;
		this.companyLogo = companyLogo;
	}
    
    public JobPosts(String jobTitle, String location, Date dateCreated, String description, String companyTitle, String companyDescription,
			String qualifications, String companyLogo) {
		super();
		this.jobTitle = jobTitle;
		this.location = location;
		this.dateCreated = dateCreated;
		this.description = description;
		this.companyTitle = companyTitle;
		this.companyDescription = companyDescription;
		this.qualifications = qualifications;
		this.companyLogo = companyLogo;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyTitle() {
		return companyTitle;
	}

	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}

	public Set<CodeHubUser> getUsers() {
        return users;
    }

    public void setUsers(Set<CodeHubUser> users) {
        this.users = users;
    }
    
    public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobPosts)) return false;
        JobPosts jobPosts = (JobPosts) o;
        return Objects.equal(getId(), jobPosts.getId()) &&
                Objects.equal(getJobTitle(), jobPosts.getJobTitle()) &&
                Objects.equal(getLocation(), jobPosts.getLocation()) &&
                Objects.equal(getDateCreated(), jobPosts.getDateCreated()) &&
                Objects.equal(getDescription(), jobPosts.getDescription()) &&
                Objects.equal(getCompanyTitle(), jobPosts.getCompanyTitle()) &&
                Objects.equal(getDescription(), jobPosts.getCompanyDescription()) &&
                Objects.equal(getDescription(), jobPosts.getQualifications()) &&
                Objects.equal(getDescription(), jobPosts.getCompanyLogo()) &&
                Objects.equal(getUsers(), jobPosts.getUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getJobTitle(), getLocation(), getDateCreated(), getDescription(), getCompanyTitle(), getCompanyDescription(), getQualifications(), getCompanyLogo());
    }

	@Override
	public String toString() {
		return "JobPosts [id=" + id + ", jobTitle=" + jobTitle + ", location=" + location + ", dateCreated="
				+ dateCreated + ", description=" + description + ", companyTitle=" + companyTitle + ", companyDescription=" + companyDescription
				+ ", qualifications=" + qualifications + ", companyLogo=" + companyLogo + "]";
	}

    
}

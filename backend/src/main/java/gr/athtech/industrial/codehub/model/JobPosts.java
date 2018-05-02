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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobPosts")
    private Set<CodeHubUser> users;

    public JobPosts() {
    }

    public JobPosts(String jobTitle, String location, String description) {
        this.jobTitle = jobTitle;
        this.location = location;
        this.dateCreated = new Date();
        this.description = description;
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

    public Set<CodeHubUser> getUsers() {
        return users;
    }

    public void setUsers(Set<CodeHubUser> users) {
        this.users = users;
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
                Objects.equal(getUsers(), jobPosts.getUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getJobTitle(), getLocation(), getDateCreated(), getDescription());
    }

    @Override
    public String toString() {
        return "JobPosts{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", location='" + location + '\'' +
                ", dateCreated=" + dateCreated +
                ", description='" + description + '\'' +
//                ", users=" + users +
                '}';
    }
}

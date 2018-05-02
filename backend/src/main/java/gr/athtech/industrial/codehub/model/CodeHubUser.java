package gr.athtech.industrial.codehub.model;

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
@Table(name = "codehub_user")
public class CodeHubUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "countryId", nullable = false)
    private Country country;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @Column(name = "latestLogin")
    private Date latestLogin;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "userStatusId")
    private UserStatus userStatus;

    @Column(name = "internalComments")
    private String internalComments;

    @Column(name = "cvPath")
    private String cvPath;

    @Column(name = "avatarPath")
    private String avatarPath;

    @Column(name = "linkedinPath")
    private String linkedinPath;

    @Column(name = "stackoverflowPath")
    private String stackOverflowPath;

    @Column(name = "gitPath")
    private String gitPath;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_techstack",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="techstackId"))
    private Set<Techstack> userTechstack;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="job_posts_user",
            joinColumns=@JoinColumn(name="userId"),
            inverseJoinColumns=@JoinColumn(name="job_posts_id"))
    private Set<JobPosts> jobPosts;

    public CodeHubUser() {
    }

    public CodeHubUser(String email, String username, String password, Role role, String firstName, String lastName, Country country, Boolean isActive, Date dateCreated, Date latestLogin) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.latestLogin = latestLogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLatestLogin() {
        return latestLogin;
    }

    public void setLatestLogin(Date latestLogin) {
        this.latestLogin = latestLogin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }


    public String getInternalComments() {
        return internalComments;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getLinkedinPath() {
        return linkedinPath;
    }

    public void setLinkedinPath(String linkedinPath) {
        this.linkedinPath = linkedinPath;
    }

    public String getStackOverflowPath() {
        return stackOverflowPath;
    }

    public void setStackOverflowPath(String stackOverflowPath) {
        this.stackOverflowPath = stackOverflowPath;
    }

    public String getGitPath() {
        return gitPath;
    }

    public void setGitPath(String gitPath) {
        this.gitPath = gitPath;
    }

    public Set<Techstack> getUserTechstack() {
        return userTechstack;
    }

    public void setUserTechstack(Set<Techstack> userTechstack) {
        this.userTechstack = userTechstack;
    }

    public Set<JobPosts> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(Set<JobPosts> jobPosts) {
        this.jobPosts = jobPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeHubUser)) return false;
        CodeHubUser that = (CodeHubUser) o;
        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(getEmail(), that.getEmail()) &&
                Objects.equal(getUsername(), that.getUsername()) &&
                Objects.equal(getPassword(), that.getPassword()) &&
                Objects.equal(getRole(), that.getRole()) &&
                Objects.equal(getFirstName(), that.getFirstName()) &&
                Objects.equal(getLastName(), that.getLastName()) &&
                Objects.equal(getCountry(), that.getCountry()) &&
                Objects.equal(isActive, that.isActive) &&
                Objects.equal(getDateCreated(), that.getDateCreated()) &&
                Objects.equal(getLatestLogin(), that.getLatestLogin()) &&
                Objects.equal(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equal(getUserStatus(), that.getUserStatus()) &&
                Objects.equal(getInternalComments(), that.getInternalComments()) &&
                Objects.equal(getCvPath(), that.getCvPath()) &&
                Objects.equal(getAvatarPath(), that.getAvatarPath()) &&
                Objects.equal(getLinkedinPath(), that.getLinkedinPath()) &&
                Objects.equal(getStackOverflowPath(), that.getStackOverflowPath()) &&
                Objects.equal(getGitPath(), that.getGitPath()) &&
                Objects.equal(getUserTechstack(), that.getUserTechstack()) &&
                Objects.equal(getJobPosts(), that.getJobPosts());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getEmail(), getUsername(), getPassword(), getRole(), getFirstName(), getLastName(), getCountry(), isActive, getDateCreated(), getLatestLogin(), getPhoneNumber(), getUserStatus(), getInternalComments(), getCvPath(), getAvatarPath(), getLinkedinPath(), getStackOverflowPath(), getGitPath(), getUserTechstack(), getJobPosts());
    }

    @Override
    public String toString() {
        return "CodeHubUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country=" + country +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                ", latestLogin=" + latestLogin +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userStatus=" + userStatus +
                ", internalComments='" + internalComments + '\'' +
                ", cvPath='" + cvPath + '\'' +
                ", avatarPath='" + avatarPath + '\'' +
                ", linkedinPath='" + linkedinPath + '\'' +
                ", stackOverflowPath='" + stackOverflowPath + '\'' +
                ", gitPath='" + gitPath + '\'' +
                ", userTechstack=" + userTechstack +
                ", jobPosts=" + jobPosts +
                '}';
    }
}

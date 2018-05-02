package gr.athtech.industrial.codehub.model;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "userProfileId")
    private UserProfile userProfile;

    @Column(name = "userStatusId")
    private UserStatus userStatus;

    @Column(name = "techstackId")
    private Techstack techstack;

    @Column(name = "internalComments")
    private String internalComments;

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

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Techstack getTechstack() {
        return techstack;
    }

    public void setTechstack(Techstack techstack) {
        this.techstack = techstack;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
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
                Objects.equal(getUserProfile(), that.getUserProfile()) &&
                Objects.equal(getUserStatus(), that.getUserStatus()) &&
                Objects.equal(getTechstack(), that.getTechstack()) &&
                Objects.equal(getInternalComments(), that.getInternalComments());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getEmail(), getUsername(), getPassword(), getRole(), getFirstName(), getLastName(), getCountry(), isActive, getDateCreated(), getLatestLogin(), getPhoneNumber(), getUserProfile(), getUserStatus(), getTechstack(), getInternalComments());
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
                ", userProfile=" + userProfile +
                ", userStatus=" + userStatus +
                ", techstack=" + techstack +
                ", internalComments='" + internalComments + '\'' +
                '}';
    }
}

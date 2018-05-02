package gr.athtech.industrial.codehub.pojos;

import java.util.Date;

/**
 *
 * @author George Lalas
 */
public class User {

    private String email;
    private String username;
    private String password;
    private String roleName;
    private String firstName;
    private String lastName;
    private String countryIsoCode;
    private Boolean isActive;
    private Date dateCreated;
    private Date latestLogin;
    private String phoneNumber;
    private String status;
    private String internalComments;
    private String cvPath;
    private String avatarPath;
    private String linkedinPath;
    private String stackOverflowPath;
    private String gitPath;

    public User() {
    }

    public User(String email, String username, String password, String roleName, String firstName, String lastName, String countryIsoCode, Boolean isActive, Date dateCreated, Date latestLogin, String phoneNumber, String status, String internalComments, String cvPath, String avatarPath, String linkedinPath, String stackOverflowPath, String gitPath) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryIsoCode = countryIsoCode;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
        this.latestLogin = latestLogin;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.internalComments = internalComments;
        this.cvPath = cvPath;
        this.avatarPath = avatarPath;
        this.linkedinPath = linkedinPath;
        this.stackOverflowPath = stackOverflowPath;
        this.gitPath = gitPath;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", countryIsoCode='" + countryIsoCode + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                ", latestLogin=" + latestLogin +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                ", internalComments='" + internalComments + '\'' +
                ", cvPath='" + cvPath + '\'' +
                ", avatarPath='" + avatarPath + '\'' +
                ", linkedinPath='" + linkedinPath + '\'' +
                ", stackOverflowPath='" + stackOverflowPath + '\'' +
                ", gitPath='" + gitPath + '\'' +
                '}';
    }
}

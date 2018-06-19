package gr.athtech.industrial.codehub.pojos;

/**
*
* @author Panagiotis Kourempanas
*/

public class JobPostsView {
	
	private String jobTitle;
	private String location;
	private String description;
	private String companyTitle;
	private String companyDescription;
	private String qualifications;
	private String companyLogo;
	
	
	public JobPostsView() {
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
    public String toString() {
        return "JobPostsView{" +
        		"jobTitle='" + jobTitle + '\'' +
        		", location='" + location + '\'' +
        		", description='" + description + '\'' +
        		", companyTitle='" + companyTitle + '\'' +
        		", companyDescription='" + companyDescription + '\'' +
        		", qualifications='" + qualifications + '\'' +
        		", companyLogo='" + companyLogo + '\'' +
        		'}';
	}
}

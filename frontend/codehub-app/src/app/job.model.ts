export class Job {
    jobTitle: string;
    location: string; 
    description: string ; 
    companyTitle: string ; 
    companyDescription: string ;
    qualifications: string ; 
    companyLogo: string;
    dateCreated: Date;
  
    constructor(jobTitle: string, location: string, description: string, companyTitle: string, 
        companyDescription: string, qualifications: string, companyLogo: string, dateCreated: Date) {
        this.jobTitle = jobTitle;
        this.location = location;
        this.description = description;
        this.companyTitle = companyTitle;
        this.companyDescription = companyDescription;
        this.qualifications = qualifications;
        this.companyLogo = companyLogo;
        this.dateCreated = dateCreated; 
      }
  }
  
  //JAVA BACKEND
  // public JobPosts(String jobTitle, String location, String description, String companyTitle, String companyDescription,
  //   String qualifications, String companyLogo) {

  // this.jobTitle = jobTitle;
  // this.location = location;
  // this.dateCreated = new Date();
  // this.description = description;
  // this.companyTitle = companyTitle;
  // this.companyDescription = companyDescription;
  // this.qualifications = qualifications;
  // this.companyLogo = companyLogo;
  
  // }
  
export class Job {
    jobTitle: string;
    location: string; 
    description: string ; 
    companyTitle: string ; 
    companyDescription: string ;
    qualifications: string ; 
    companyLogo: string;
  
    constructor(jobTitle: string, location: string, description: string, companyTitle: string, 
        companyDescription: string, qualifications: string, companyLogo: string) {
        this.jobTitle = jobTitle;
        this.location = location;
        this.description = description;
        this.companyTitle = companyTitle;
        this.companyDescription = companyDescription;
        this.qualifications = qualifications;
        this.companyLogo = companyLogo;
      }
  }
  
//   JOB pojo

//   private String jobTitle;
//   private String location;
//   private String description;
//   private String companyTitle;
//   private String companyDescription;
//   private String qualifications;
//   private String companyLogo;
  
export class User {
  email: string;
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  countryIsoCode: string;
  isActive: Boolean; 
  dateCreated : Date;
  latestLogin: Date;  
  phoneNumber: string;
  status: string; 
  internalComments: string;
  cvPath: string;  
  avatarPath: string;
  linkedinPath: string;
  stackOverflowPath: string;
  gitPath: string;

  // userTechstack: string[];      
  // roleName: string;  ->  candidate / internal
  // status -> ?? e.g. Phone Interest?? 
    
  constructor(email: string, username: string, password: string, firstName: string,lastName: string, countryIsoCode: string, isActive: Boolean, dateCreated : Date, latestLogin: Date,
    phoneNumber: string, status: string, internalComments: string, cvPath: string, avatarPath: string, linkedinPath: string, stackOverflowPath: string,  gitPath: string) {
      this.email = email;
      this.username = username;
      this.password = password;
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
}

export class User {
  email: string;
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  country: string;    
  linkedinPath: string;
  stackOverflowPath: string;
  gitPath: string;
  phoneNumber: string;
  userTechstack: string[];
      
  roleName: string;    
  dateCreated : Date;
  latestLogin: Date;
  isActive: Boolean;
  
  constructor(firstName: string, lastName: string, userTechstack: string[], linkedinPath: string, phoneNumber: string, 
    email: string, password: string, roleName: string, country: string, dateCreated: Date, latestLogin: Date, isActive: Boolean, 
    stackOverflowPath: string, gitPath: string, username: string) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.userTechstack = userTechstack;
    this.linkedinPath = linkedinPath;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.roleName = roleName;
    this.country = country;
    this.dateCreated = dateCreated;
    this.latestLogin = latestLogin;
    this.isActive = isActive;
    this.stackOverflowPath = stackOverflowPath;
    this.gitPath = gitPath;
    this.username = username;

  }
}

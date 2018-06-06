export class User {

    firstName: string;
    lastName: string;
    techStack: string[];
    linkedInLink: string;
    phoneNumber: string;
    email: string;
    password: string;
    roleName: string;
    countryIsoCode: string;
    dateCreated : Date;
    latestLogin: Date;
    isActive: Boolean;
    stackOverflowLink: string;
    githubLink: string;
    username: string;



  constructor(firstName: string, lastName: string, techStack: string[], linkedInLink: string, phoneNumber: string, email: string, password: string, roleName: string, countryIsoCode: string, dateCreated: Date, latestLogin: Date, isActive: Boolean, stackOverflowLink: string, githubLink: string, username: string) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.techStack = techStack;
    this.linkedInLink = linkedInLink;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.roleName = roleName;
    this.countryIsoCode = countryIsoCode;
    this.dateCreated = dateCreated;
    this.latestLogin = latestLogin;
    this.isActive = isActive;
    this.stackOverflowLink = stackOverflowLink;
    this.githubLink = githubLink;
    this.username = username;

  }
}

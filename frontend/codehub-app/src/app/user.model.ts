export class User {

    firstName: string;
    lastName: string;
    techStack: string;
    profileLink: string;
    phoneNumber: string;
    email: string;
    password: string;
    roleName: string;
    countryIsoCode: string;
    dateCreated : Date;
    latestLogin: Date;
    isActive: Boolean;


  constructor(firstName: string, lastName: string, techStack: string, profileLink: string, phoneNumber: string, email: string, password: string, roleName: string, countryIsoCode: string, dateCreated: Date, latestLogin: Date, isActive: Boolean) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.techStack = techStack;
    this.profileLink = profileLink;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.roleName = roleName;
    this.countryIsoCode = countryIsoCode;
    this.dateCreated = dateCreated;
    this.latestLogin = latestLogin;
    this.isActive = isActive;
  }
}

export class Program {
 programTitle: String;
 price: String;
 smallDescription: String;
 mainDescription: String;
 additionalInfo: String;
 category: String;
 programLogo: String;

  constructor(programTitle: String, price: String, smallDescription: String, mainDescription: String, additionalInfo: String, category: String, programLogo: String) {
    this.programTitle = programTitle;
    this.price = price;
    this.smallDescription = smallDescription;
    this.mainDescription = mainDescription;
    this.additionalInfo = additionalInfo;
    this.category = category;
    this.programLogo = programLogo;
  }

}

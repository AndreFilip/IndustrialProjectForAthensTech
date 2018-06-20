export class Country {
    isoCode;
    nameCapital;
    nameView;
    isoCode3;
    numCode;
    phoneCode;

    constructor(isoCode: string, nameCapital: string, nameView: string, isoCode3: string, 
        numCode: string, phoneCode: string) {
        this.isoCode = isoCode;
        this.nameCapital= nameCapital;
        this.nameView= nameView;
        this.isoCode3= isoCode3;
        this.numCode= numCode;
        this.phoneCode= phoneCode;
         }
}

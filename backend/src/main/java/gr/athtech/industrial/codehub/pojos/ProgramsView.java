package gr.athtech.industrial.codehub.pojos;

/**
*
* @author Panagiotis Kourempanas
*/

public class ProgramsView {

	private String programTitle;
	private String price;
	private String smallDescription;
	private String mainDescription;
	private String additionalInfo;
	private String category;
	private String programLogo;
	
	
	public ProgramsView() {
	}

	
	public String getProgramTitle() {
		return programTitle;
	}

	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSmallDescription() {
		return smallDescription;
	}

	public void setSmallDescription(String smallDescription) {
		this.smallDescription = smallDescription;
	}

	public String getMainDescription() {
		return mainDescription;
	}

	public void setMainDescription(String mainDescription) {
		this.mainDescription = mainDescription;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProgramLogo() {
		return programLogo;
	}

	public void setProgramLogo(String programLogo) {
		this.programLogo = programLogo;
	}
	
	@Override
    public String toString() {
        return "ProgramsView{" +
        		"programTitle='" + programTitle + '\'' +
        		", price='" + price + '\'' +
        		", smallDescription='" + smallDescription + '\'' +
        		", mainDescription='" + mainDescription + '\'' +
        		", additionalInfo='" + additionalInfo + '\'' +
        		", category='" + category + '\'' +
        		", programLogo='" + programLogo + '\'' +
        		'}';
	}
}
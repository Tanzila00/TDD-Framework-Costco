package constants;

public enum Attribute {
	MAX_LENGTH	("maxlength"), INNER_HTML("innerHTML");

String attribute;

	private Attribute(String attribute) {// constructor -to put values, also works like setter method
		this.attribute = attribute;
	}
//public void setString(String attribute) {//CAN'T DO SETTER BECAUSE IT WILL GIVE CONSTRUCTOR ATTRIBUTE(STRING) UNDEFINED
//	this.attribute=attribute;
//	
//}
//	
	 public String getAttribute() {// getter method for private
		 return attribute;
	 }
	@Override
	public String toString() {// override-superclass object-to convert the constructor attribute-values
		return attribute;
	}
	 


}

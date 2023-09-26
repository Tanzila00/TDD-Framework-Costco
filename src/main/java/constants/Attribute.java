package constants;



public enum Attribute {
	MAX_LENGTH("maxlength"),
	INNER_HTML("innerHTML");
	String attribute;
	
	private Attribute(String attribute) {//constructor -to put values
		this.attribute = attribute;
	}
	
	public String getAttribute() {//optional-custom method
		return attribute;
	}
	
	@Override
	public String toString() {//override-superclass object-to convert the constructor attribute-values
		return attribute;
	}
		
	}


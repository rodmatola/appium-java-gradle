package resources;

public class Platform {
	
	String platform;
	
	public Platform () {
		platform = System.getProperty( "environment" );
    		if (platform == null)
    			platform = System.getenv( "environment" );
	}
	
	public String getPlatform() {
		return this.platform;
	}

}

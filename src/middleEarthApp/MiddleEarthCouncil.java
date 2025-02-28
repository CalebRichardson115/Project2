package middleEarthApp;

public class MiddleEarthCouncil {
	//
	private static MiddleEarthCouncil instance = null;
	private CharacterManager characterManager;
	//private final static String path = ;
	
	private MiddleEarthCouncil(){
		//May be unnecessary. Will need to test to see if needed.
		this.characterManager = new CharacterManager();
	}
	//Returns the singleton instance. Makes a new instance only if it does not yet exist. 
	static MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	CharacterManager getCharacterManager() {
		return characterManager;
	}
	

}

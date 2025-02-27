package middleEarthApp;

public class MiddleEarthCouncil {
	//
	private static MiddleEarthCouncil instance = null;
	private CharacterManager characterManager;
	//private final static String path = ;
	
	private MiddleEarthCouncil(){
		this.characterManager = new CharacterManager();
	}
	
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

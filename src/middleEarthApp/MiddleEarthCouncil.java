package middleEarthApp;
/*
 * @author Caleb Richardson
 * @version 3-4-2025
 */
//Singleton class that allows for one instance of a character manager to exist.
public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance = null;
	private CharacterManager characterManager;
	//Initializes a character manager for the council instance
	private MiddleEarthCouncil(){
		this.characterManager = new CharacterManager();
	}
	//Returns the singleton instance. Makes a new instance only if it does not yet exist. 
	static MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	//Returns the characterManager tied to the instance. 
	CharacterManager getCharacterManager() {
		return characterManager;
	}
}

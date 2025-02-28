package middleEarthApp;

import middleEarthApp.MiddleEarthCharacter;
public class main {
	public static void main(String[] args) {
		//For now, this is just to test other classes. Menu implementation will come later.
		//MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		//CharacterManager manager = council.getCharacterManager();
		Human guy1 = new Human("Jack Black", 10.0, 5.5);
		Human guy2 = new Human("Elton John", 100.4, 30.5);
		Orc orc1 = new Orc("Guy", 5.0, 5.0);
		Dwarf dwarf1 = new Dwarf("Guy", 15.0, 13.0);
		orc1.attack(guy2);
		guy2.displayInfo();
		//manager.addCharacter(new Human("Bob", 10.0, 5.0));
		//manager.addCharacter(new Human("Joe", 15.0, 10.5));
		
	}

}

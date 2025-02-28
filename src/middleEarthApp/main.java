package middleEarthApp;

import middleEarthApp.MiddleEarthCharacter;
public class main {
	public static void main(String[] args) {
		//For now, this is just to test other classes. Menu implementation will come later.
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		Human guy1 = new Human("Jack Black", 10.0, 5.5);
		Human guy2 = new Human("Elton John", 100.4, 30.5);
		Orc orc1 = new Orc("Guy", 5.0, 5.0);
		Dwarf dwarf1 = new Dwarf("Mr. Dwarf", 15.0, 13.0);
		Wizard wiz1 = new Wizard("Howl", 350.5, 500.0);
		dwarf1.attack(guy2);
		guy2.displayInfo();
		manager.addCharacter(guy1);
		manager.addCharacter(orc1);
		manager.addCharacter(guy2);
		manager.addCharacter(dwarf1);
		manager.addCharacter(wiz1);
		manager.displayAllCharacters();
		
	}

}

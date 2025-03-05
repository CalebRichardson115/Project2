package middleEarthApp;
/*
 * CharacterManager is a an array that allows for the management of multiple
 * MiddleEarthCharacters with methods to add new characters, delete them, print them all,
 * retrieve them, and update their values. Allows for dynamic array resizing once capacity is reached.
 */
public class CharacterManager {
	MiddleEarthCharacter[] characters;
	int size;
	//Adds a new character to the characters array and updates the array size. The total length is doubled every time it is at capacity. 
	boolean addCharacter(MiddleEarthCharacter c) {
		//Returns false if passed an invalid character.
		if(c == null) {
			return false;
		}
		//Initializes the array if it is the first element to be added and sets the initial length to be 2.
		if(characters == null || size == 0) {
			characters = new MiddleEarthCharacter[1];
			characters[0] = c;
			size++;
			//makes the characters array into a copy of itself with double the capacity.
			MiddleEarthCharacter[] copy = new MiddleEarthCharacter[size*2];
			for(int i = 0; i < size;i++) {
				copy[i] = characters[i];
			}
			characters = copy;
			return true;
		}
		characters[size] = c;
		size++;
		//Resizes the array once the size reaches capacity by copying the array and doubling the size
		if(size >= characters.length) {
			MiddleEarthCharacter[] copy = new MiddleEarthCharacter[size*2];
			for(int i = 0; i < size;i++) {
				copy[i] = characters[i];
			}
			characters = copy;
		}
		return true;
	}
	//Removes a character by finding the position in the characters array to remove and then shifts all elements left at the removal point.
	boolean deleteCharacter(MiddleEarthCharacter character) {
		//Goes through the characters array to find the point of removal. 
		int removalIndex = -1;
		for(int i = 0; i < size; i++) {
			if(character == characters[i]) {
				removalIndex = i;
			}
		}
		//Returns false if the character was not present in the manager.
		if(removalIndex == -1) {
			return false;
		}
		//Shifts elements to the left starting at the point of removal. Will not go out of bounds due to array resizing logic.
		for(int i = removalIndex; i < size;i++) {
			characters[i] = characters[i+1];
		}
		size--;
		return true;
	}
	//Searches the characters array for a matching name and then returns that character if the name matches. Returns null if that character is not in the array.
	MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) {
			if(characters[i].name.equals(name)) {
				return characters[i];
			}
		}
		//Returns null if character is not present.
		return null;
	}
	//Changes the name, health, and attack power of a character upon locating it in the characters array.
	boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		int charIndex = -1;
		for(int i = 0; i < size;i++) {
			if(character == characters[i]) {
				charIndex = i;
			}
		}
		//Returns false if the character is not found.
		if(charIndex == -1) {
			return false;
		}
		characters[charIndex].name = name;
		characters[charIndex].health = health;
		characters[charIndex].power = power;
		return true;
	}
	
	//Prints all characters in the manager array. Returns if empty. 
	void displayAllCharacters() {
		if(characters == null || size == 0) {
			return;
		}
		for(int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
}

package middleEarthApp;
import java.util.Arrays;

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
			System.out.println("in");
			characters = new MiddleEarthCharacter[1];
			characters[0] = c;
			size++;
			//makes the characters array into a copy of itself with double the capacity.
			characters = Arrays.copyOf(characters, this.size*2);
			System.out.println("Returning");
			return true;
		}
		System.out.println("Length: " + this.characters.length);
		System.out.println("Num of elements: " + this.size);
		characters[size] = c;
		size++;
		if(size >= characters.length) {
			characters = Arrays.copyOf(characters, size*2);
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
				System.out.println("Found");
				return characters[i];
			}
		}
		//Returns null if character is not present.
		return null;
	}
	
	boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		int charIndex = -1;
		for(int i = 0; i < size;i++) {
			if(character == characters[i]) {
				charIndex = i;
			}
		}
		if(charIndex == -1) {
			System.out.println("Returning false");
			return false;
		}
		System.out.println("Returning true");
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

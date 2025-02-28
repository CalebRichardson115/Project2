package middleEarthApp;
import java.util.Arrays;
//import middleEarthApp.MiddleEarthCharacter;
public class CharacterManager {
	MiddleEarthCharacter[] characters;
	int size;
	
	//Adds a new character to the characters array. Increments size as characters are added. 
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
	
	
	
	void displayAllCharacters() {
		for(int i = 0; i < size; i++) {
			characters[i].displayInfo();
		}
	}
}

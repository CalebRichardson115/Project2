package middleEarthApp;
import java.util.Arrays;
//import middleEarthApp.MiddleEarthCharacter;
public class CharacterManager {
	MiddleEarthCharacter[] characters;
	int size;
	

	boolean addCharacter(MiddleEarthCharacter c) {
		System.out.println(this.characters.length);
		System.out.println(this.size);
		if(this.size > this.characters.length) {
			this.characters = Arrays.copyOf(this.characters, 2*this.size);
		}
		this.characters[size] = c;
		this.size++;
		return true;
	}
}

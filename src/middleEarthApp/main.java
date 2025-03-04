package middleEarthApp;
import java.util.Scanner;
/*
 * @author Caleb Richardson
 * @version 3-4-2025
 */
public class main {
	//
	public static void main(String[] args) {
		//Initializes the scanner for input and gets the single instance of the character manager.
		Scanner input = new Scanner(System.in);
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		//boolean that keeps the loop going so long as the user has not decided to exit the app.
		boolean menuActive = true;
		System.out.println("Welcome to the Middle Earth App.");
		//Active until the user inputs "Q"
		while(menuActive == true) {
			System.out.println("Enter the following commands to manage your characters.");
			System.out.println("Enter \"N\" to add a new character. Enter \"V\" to view all your characters.");
			System.out.println("Enter \"U\" to update a character. Enter \"D\" to delete a character.");
			System.out.println("Enter \"A\" to execute any character's attack actions. Enter \"Q\" to exit the app.");
			String command = input.nextLine().toUpperCase();
			switch(command) {
			case "N":
				//Prompts the user for new character details
				   System.out.println("Enter the new character's name: ");
				   String name = input.nextLine();
				   System.out.println("Now enter the character's attack power in the form of a double: ");
				   double power = input.nextDouble();
				   System.out.println("Now enter the character's total health points in the form of a double: ");
				   double health = input.nextDouble();
				   System.out.println("What race will this character be? The options are: Human, Orc, Dwarf, Wizard, and Elf");
				   System.out.println("Enter your character's race: ");
				   //Necessary to have a nextLine so that a string input can be taken after a double.
				   input.nextLine();
				   String race = input.nextLine().toLowerCase();
				   //Adds a new
				   switch(race) {
				      case "human":
				    	  manager.addCharacter(new Human(name, health, power));
				    	  break;
				      case "orc":
				    	  manager.addCharacter(new Orc(name, health, power));
				    	  break;
				      case "dwarf":
				    	  manager.addCharacter(new Dwarf(name, health, power));
				    	  break;
				      case "wizard":
				    	  manager.addCharacter(new Wizard(name, health, power));
				    	  break;
				      case "elf":
				    	  manager.addCharacter(new Elf(name, health, power));
				    	  break;
				       default:
				    	   System.out.println("Something went wrong with the input. Please try again.");
				    	   break;
				       }
				   break;
			case "V":
				System.out.println("Here are all of the current characters: ");
				manager.displayAllCharacters();
				break;
			//Updates a selected character with a new name, attack power, and health based on user inputs.
			case "U":
				System.out.println("Enter the name of the character you wish to update: ");
				String updateName = input.nextLine();
				System.out.println("Enter the new name for the character: ");
				String newName = input.nextLine();
				System.out.println("Now enter the new attack power for the character: ");
				double newPower = input.nextDouble();
				System.out.println("Now enter the new total health for the character: ");
				double newHealth = input.nextDouble();
				manager.updateCharacter(manager.getCharacter(updateName), newName, newHealth, newPower);
				break;
			//deletes a character via user input if it is a valid character.
			case "D":
				System.out.println("Enter the name of the character you wish to delete: ");
				String deletedCharacter = input.nextLine();
				manager.deleteCharacter(manager.getCharacter(deletedCharacter));
				break;
			//Allows any character to attack any other character based on user inputs.
			case "A":
				System.out.println("Enter the name of the attacker: ");
				String attacker = input.nextLine();
				System.out.println("Now enter then name of the character to be attacked: ");
				String attackee = input.nextLine();
				MiddleEarthCharacter attackingCharacter = manager.getCharacter(attacker);
				MiddleEarthCharacter attackedCharacter = manager.getCharacter(attackee);
				boolean attackBoolean = attackingCharacter.attack(attackedCharacter);
				if(!attackBoolean) {
					System.out.println("The attack did not go through or did zero damage.");
				}
				else {
					System.out.println("Attack successful");
				}
				break;
			//Sets the boolean that keeps the loop going to false if the use inputs Q.
			case "Q":
				   System.out.println("App terminated.");
				   menuActive = false;
				   break;
			//Sends out a message if the input is invalid.
			default:
				System.out.println("Something went wrong with the input. Please try again.");
				break;
			}
		}
	}

}

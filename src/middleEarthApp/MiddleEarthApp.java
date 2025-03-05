package middleEarthApp;
import java.util.Scanner;
//Menu-driven interface for the Middle Earth App project.
//Allows the user to utilize the app until they decide to close it.
public class MiddleEarthApp {
	//main method for app execution.
	public static void main(String[] args) {
		//Initializes the scanner for input and gets the single instance of the character manager.
		Scanner input = new Scanner(System.in);
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		//boolean that keeps the loop going so long as the user has not decided to exit the app.
		boolean menuActive = true;
		//Explains the rules of the game.
		System.out.println("Welcome to the Middle Earth App.");
		System.out.println("Here, you can make, destroy, and update all sorts of characters as well as making them battle one another.");
		System.out.println("And the best part is that you set the stage, all characters are of your own creation and are at your full discretion.");
		System.out.println("The attack rules are as follows:");
		System.out.println("Each character race is strong against another while also weak to another. No character of the same race may strike its own kin.");
		System.out.println("Human characters are strong against Wizards but weak to Orcs while Orcs are strong against humans but weak to Elves.");
		System.out.println("Elves are strong against Orcs but weak to Dwarves while Dwarves are strong against Eleves but weak to Wizards.");
		System.out.println("Wizards are good against Dwarves but weak to Humans.");
		System.out.println("Every character that attacks a race it is strong against does 1.5x damage against it.");
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
				   while(!input.hasNextDouble()) {
					   System.out.println("Input a valid double (i.e. 10.5)");
					   input.nextLine();
				   }
				   double power = input.nextDouble();
				   System.out.println("Now enter the character's total health points in the form of a double: ");
				   //Repeated code block to ensure that only a double can be inputed to avoid errors.
				   while(!input.hasNextDouble()) {
					   System.out.println("Input a valid double (i.e. 10.5)");
					   input.nextLine();
				   }
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
				while(!input.hasNextDouble()) {
					   System.out.println("Input a valid double (i.e. 10.5)");
					   input.nextLine();
				   }
				double newPower = input.nextDouble();
				System.out.println("Now enter the new total health for the character: ");
				while(!input.hasNextDouble()) {
					   System.out.println("Input a valid double (i.e. 10.5)");
					   input.nextLine();
				   }
				double newHealth = input.nextDouble();
				boolean updateBoolean = manager.updateCharacter(manager.getCharacter(updateName), newName, newHealth, newPower);
				if(!updateBoolean) {
					System.out.println("Update failed");
				}
				break;
			//deletes a character via user input if it is a valid character.
			case "D":
				System.out.println("Enter the name of the character you wish to delete: ");
				String deletedCharacter = input.nextLine();
				boolean deleteBool = manager.deleteCharacter(manager.getCharacter(deletedCharacter));
				if(!deleteBool) {
					System.out.println("Deletion failed.");
					break;
				}
				System.out.println("Deletion successful.");
				break;
			//Allows any character to attack any other character based on user inputs.
			case "A":
				System.out.println("Enter the name of the attacker: ");
				String attacker = input.nextLine();
				System.out.println("Now enter then name of the character to be attacked: ");
				String attackee = input.nextLine();
				MiddleEarthCharacter attackingCharacter = manager.getCharacter(attacker);
				MiddleEarthCharacter attackedCharacter = manager.getCharacter(attackee);
				//Catches invalid inputs so that the attack does not reference null.
				if(attackingCharacter == null || attackedCharacter == null) {
					System.out.println("Invalid characters. Try again.");
					break;
				}
				boolean attackBoolean = attackingCharacter.attack(attackedCharacter);
				if(!attackBoolean) {
					System.out.println("The attack did not go through or did zero damage.");
				}
				else {
					System.out.println("Attack successful");
				}
				break;
			//Sets the boolean that keeps the app up to false if the user inputs Q.
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

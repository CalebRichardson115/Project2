package middleEarthApp;
//Dwarf is a subclass of MiddleEarthCharacter
public class Dwarf extends MiddleEarthCharacter{
	//Initializes a Dwarf
	public Dwarf(String name, double health, double power) {
		super(name,health,power);
	}
	//Returns "Dwarf" for the attack method and displayInfo method.
	@Override
	public String getRace() {
		return "Dwarf";
	}
	//Attack logic for Dwarf subclass. Returns false (zero damage) for Dwarf and Wizard targets, 1.5 damage for Elf targets, and regular damage for other classes.
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Dwarf" || target.getRace() == "Wizard") {
			return false;
		}
		if(target.getRace() == "Elf") {
			target.health -= this.power*1.5;
		}
		else {
			target.health -= this.power;
		}
		return true;
	}

}
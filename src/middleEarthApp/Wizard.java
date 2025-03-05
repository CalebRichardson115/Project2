package middleEarthApp;
//Wizard is a subclass of MiddleEarthCharacter
public class Wizard extends MiddleEarthCharacter {
	//Initializes a Wizard
	public Wizard(String name, double health, double power) {
		super(name,health,power);
	}
	//Returns "Wizard" for the attack method and displayInfo method.
	@Override
	public String getRace() {
		return "Wizard";
	}
	//Attack logic for Wizard subclass. Returns false (zero damage) for Wizard and Human targets, 1.5 damage for Dwarf targets, and regular damage for other classes.
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Wizard" || target.getRace() == "Human") {
			return false;
		}
		if(target.getRace() == "Dwarf") {
			target.health -= this.power*1.5;
		}
		else {
			target.health -= this.power;
		}
		return true;
	}

}

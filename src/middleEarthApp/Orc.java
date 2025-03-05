package middleEarthApp;
//Orc is a subclass of MiddleEarthCharacter
public class Orc extends MiddleEarthCharacter {
	//Initializes an Orc
	public Orc(String name, double health, double power) {
		super(name,health,power);
	}
	//Returns "Orc" for the attack method and displayInfo method.
	@Override
	public String getRace() {
		return "Orc";
	}
	//Attack logic for Orc subclass. Returns false (zero damage) for Orc and Elf targets, 1.5 damage for Human targets, and regular damage for other classes.
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Orc" || target.getRace() == "Elf") {
			return false;
		}
		if(target.getRace() == "Human") {
			target.health -= this.power*1.5;
		}
		else {
			target.health -= this.power;
		}
		return true;
	}

}

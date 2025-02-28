package middleEarthApp;

public class Dwarf extends MiddleEarthCharacter{

	public Dwarf(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Dwarf";
	}
	
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
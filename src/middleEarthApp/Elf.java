package middleEarthApp;

public class Elf extends MiddleEarthCharacter{

	public Elf(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Elf";
	}
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Elf" || target.getRace() == "Dwarf") {
			return false;
		}
		if(target.getRace() == "Orc") {
			target.health -= this.power*1.5;
		}
		else {
			target.health -= this.power;
		}
		return true;
	}

}
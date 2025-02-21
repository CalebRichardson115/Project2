package middleEarthApp;

public class Elf extends MiddleEarthCharacter{

	public Elf(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Elf";
	}

}
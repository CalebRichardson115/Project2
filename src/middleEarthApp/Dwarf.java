package middleEarthApp;

public abstract class Dwarf extends MiddleEarthCharacter{

	public Dwarf(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Dwarf";
	}

}
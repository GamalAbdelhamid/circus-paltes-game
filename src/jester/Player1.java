package jester;

public class Player1 extends Jester {
	private static Jester instance  = new Player1();
	private Player1() {
		
	}
	
	public static Jester getInstance() {
		return instance;
	}
}

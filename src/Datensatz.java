
public class Datensatz {
	
	public int key;
	String daten;
	
	public Datensatz(int n) {
		daten = "test";
		key = (int) (Math.random() * n + 1);
	}

}

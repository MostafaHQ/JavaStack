public class TestPuzzleJava {

	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		System.out.println(generator.getTenRolls());
		System.out.println(generator.getRandomLetter());
		System.out.println(generator.generatePassword());
		System.out.println(generator.getNewPasswordSet(3));
	}
}

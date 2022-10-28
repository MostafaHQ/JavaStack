import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        Random myRandom = new Random();
        for (int i = 0; i < 10; i++) {
            myArray.add(myRandom.nextInt(20));
        }
        return myArray;
    }

    public String getRandomLetter() {
        String[] letArray = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "W", "X", "Y", "Z" };
        Random myAlpha = new Random();
        String myLetter = letArray[myAlpha.nextInt(26)];
        return myLetter;
    }

    public String generatePassword() {
        String myPassword = new String();
        for (int i = 0; i < 8; i++) {
            myPassword += getRandomLetter();
        }
        return myPassword;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> setPassword = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            setPassword.add(generatePassword());
        }
        return setPassword;
    }

}
import java.util.HashMap;
import java.util.Set;

public class Hashmatique {

    public static void main(String[] args) {
        HashMap<String, String> tracklist = new HashMap<String, String>();
        tracklist.put("Enemy", "Look out for yourself...");
        tracklist.put("The Search", "Hey, Nate, how's life?");
        tracklist.put("Snap", "Snipping one,two where are you...");
        String lyrics = tracklist.get("The Search");
        System.out.println(lyrics);
        for (String key : tracklist.keySet()) {
            System.out.println(key);
            System.out.println(tracklist.get(key));
        }
    }
}

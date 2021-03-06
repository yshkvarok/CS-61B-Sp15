/** 
 *  @author Josh Hug
 */

/* TODO: Modify Dog so that this file and DogLauncher compile and run. */

public class Dog {
    private String name;
    private String breed;
    private double size;
    private VoiceInHead vih;

    public Dog(String n, String b, double s) {
        name = n;
        breed = b;
        size = s;
        vih = new VoiceInHead();
    }

    public String toString() {
        return name + " is a " + breed + " weighing " + size + " lbs.";
    }

    public void listenToVoice() {
        vih.speak();
    }

    public class VoiceInHead {
        public void speak() {
            System.out.println(name + ", hello.");
        }
    }
} 
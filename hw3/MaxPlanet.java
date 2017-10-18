import java.util.Comparator;
/* Import anything else you need here. */

/**
 * MaxPlanet.java
 */

public class MaxPlanet {

    /** Returns the Planet with the maximum value according to Comparator c. */
    public static Planet maxPlanet(Planet[] planets, Comparator<Planet> c) {
        Planet max = new Planet(0, 0, 0, 0, 0, null, 0);
        for (int i = 0; i < planets.length; i++) {
        	if (c.compare(planets[i], max) > 0) max = planets[i];
        }
        return max;
    }
}
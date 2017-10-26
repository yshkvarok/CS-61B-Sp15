package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;
import java.awt.Color;
import java.util.Map;
import java.util.List;

/** An implementation of a motile pacifist photosynthesizer.
 *  @author Josh Hug
 */
public class Clorus extends Creature {
    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    /** energy lost on move */
    private final double energyOnMove = 0.03;
    /** energy lost on stay */
    private final double energyOnStay = 0.01;

    /** fraction of energy to retain when replicating. */
    private double halfEnergy = 0.5;

    /** creates Clorus with energy equal to E. */
    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    /** creates a Clorus with energy equal to 1. */
    public Clorus() {
        this(1);
    }

    public Color color() {
        return color(r, g, b);
    }

    public void attack(Creature c) {
        energy += c.energy();
    }

    public void move() {
        energy -= energyOnMove;
    }

    public void stay() {
        energy = energyOnStay;
    }

    public Clorus replicate() {
        energy *= halfEnergy;
        return new Clorus(energy);
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        if (empties.size() == 0) {
            return new Action(Action.ActionType.STAY);
        }

        List<Direction> plips = getNeighborsOfType(neighbors, "plip");
        if (plips.size() > 0 && empties.size() > 0) {
            double temp = Math.random() * plips.size();
            return new Action(Action.ActionType.ATTACK, plips.get((int) Math.floor(temp)));
        }

        if (energy >= 1) {
            double temp = Math.random() * empties.size();
            return new Action(Action.ActionType.REPLICATE, empties.get((int) Math.floor(temp)));
        }

        double temp = Math.random() * empties.size();
        return new Action(Action.ActionType.MOVE, empties.get((int) temp));
    }
}

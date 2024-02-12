package organisms;
import javax.lang.model.type.NullType;
import java.util.HashMap;
import java.util.Map;

public class Organism {
    // declaration of attributes akin to variables in class scope
    // use dict to store values instead of individual declarations
    // hashmaps in Java cannot hold primitive types (float), only objects (Float).
    protected Map<String, Float> attributes = new HashMap<>();

    String name;

    public String get_name() {
        return this.name;
    }

    void assign(Float health, Float mana, Float stamina, Float defense, Float phys_atk, Float mag_atk, Float speed, Float intelligence) {
        attributes.put("health", health);
        attributes.put("mana", mana);
        attributes.put("stamina", stamina);
        attributes.put("defense", defense);
        attributes.put("phys_atk", phys_atk);
        attributes.put("mag_atk", mag_atk);
        attributes.put("speed", speed);
        attributes.put("intelligence", intelligence);
    }

    // java does not support default parameter values, so we have to do overloading

    public Organism(String name) { // constructor with name input
        // java can autobox (automatically convert) floats to Floats by slapping an f on the back of a float.
        this.name = name;
        this.assign(100f, 100f, 100f, 10f, 4f, 0f, 100f, 100f);
        System.out.println("Organism created, name only");
    }

    public Organism(String name, Map<String, Float> stats) { // constructor with stats input
        System.out.println("Organism created, args");
        this.name = name;

        this.assign(stats.getOrDefault("Health", 100f), stats.getOrDefault("Mana", 100f),
                stats.getOrDefault("Stamina", 100f), stats.getOrDefault("Defense", 10f),
                stats.getOrDefault("Phys_Atk", 4f), stats.getOrDefault("Mag_Atk", 0f),
                stats.getOrDefault("Speed", 100f), stats.getOrDefault("Int", 100f));
    }

    public Float getStat(String stat) {
        // Float can take on null values, but float cannot. The difference between a primitive type and an object.
        return attributes.getOrDefault(stat.toLowerCase(), null);
    }

    public void move() {
        System.out.printf("%s can move.\n", this.get_name());
    }

    public float calc_damage() {
        return attributes.get("phys_atk");
    }

    public void attack() {
        // %s for string, %d for int, %.2f for float
        System.out.printf("%s did %.2f damage in an attack!\n", this.get_name(), this.calc_damage());
    }

}

package academic.model;

public class Individu {
    protected String id;
    protected String name;

    public Individu(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

package ro.siit.collections.model;
//lista de facultati
public enum CollegeEnum {

    POLITENICA("Politehnica"),
    STIINTE_ECONOMICE("Stiinte Economice"),
    STIINTE_POLITICE("Stiinte Politice"),
    DREPT("Drept"),
    MEDICINA("Medicina"),
    LITERE("Litere");

    private final String name;

    CollegeEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

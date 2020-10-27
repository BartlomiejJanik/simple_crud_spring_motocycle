package pl.sda.simple_crud_spring_motocycle;

public enum Color {
    WHITE("biały"),
    RED("czerwony"),
    GREEN("zielony"),
    ORANGE("pomarańczowy");

    private String plName;

    Color(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }
}

package ch.heigvd.pdl.refactoring;

public enum Color {
    BLUE("blue"),
    RED("red"),
    YELLOW("yellow"),
    NO_COLOR("no color");

    private final String name;

    Color(String color) { name = color; }

    @Override
    public String toString() { return name; }
}

package ch.heigvd.pdl.refactoring;

public enum Color {
    BLUE(1, "blue"),
    RED(2, "red"),
    YELLOW(3, "yellow"),
    NO_COLOR(0, "no color");

    private final int code;
    private final String color;

    Color(int code, String color) {
        this.code = code;
        this.color = color;
    }

    public static String getColor(int code) {
        for(Color color : Color.values()) {
            if(color.code == code) {
                return color.color;
            }
        }
        return NO_COLOR.color;
    }
}

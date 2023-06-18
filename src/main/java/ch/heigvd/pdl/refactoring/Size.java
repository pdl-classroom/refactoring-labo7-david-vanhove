package ch.heigvd.pdl.refactoring;

public enum Size {
    XS(1, "XS"),
    S(2, "S"),
    M(3, "M"),
    L(4, "L"),
    XL(5, "XL"),
    XXL(6, "XXL"),
    NOT_APPLICABLE(-1, "Size not applicable"),
    INVALID_SIZE(0, "Invalid Size");

    private final int code;
    private final String size;

    Size(int code, String size) {
        this.code = code;
        this.size = size;
    }

    public static String getSize(int code) {
        for(Size size : Size.values()) {
            if(size.code == code) {
                return size.size;
            }
        }
        return INVALID_SIZE.size;
    }
}
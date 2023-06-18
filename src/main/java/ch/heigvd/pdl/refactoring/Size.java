package ch.heigvd.pdl.refactoring;

public enum Size {
    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    NOT_APPLICABLE("Size not applicable"),
    INVALID_SIZE("Invalid Size");

    private final String name;

    Size(String size) { name = size; }

    @Override
    public String toString() { return name; }
}
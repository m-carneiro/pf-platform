package apps.progfort.platform.enums;

public enum Dificulties {
    EASY, MEDIUM, HARD;

    public Integer code() {
        return switch (this) {
            case EASY -> 1;
            case MEDIUM -> 2;
            case HARD -> 3;
        };
    }
}

package movies.domain.models;

public enum MovieType {
    REGULAR(0),
    NEW_RELEASE(1),
    CHILDREN(2);

    private final int code;

    MovieType(int code) {
        this.code = code;
    }

    public static MovieType fromCode(int code) throws IllegalArgumentException {
        for (MovieType type : values()) {
            if (type.code == code) {
                return type;
            }
        }

        throw new IllegalArgumentException("Invalid Movie Code");
    }
}

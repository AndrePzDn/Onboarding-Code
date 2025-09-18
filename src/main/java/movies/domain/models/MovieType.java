package movies.domain.models;

import movies.exceptions.InvalidPriceCodeException;

public enum MovieType {
    REGULAR(0),
    NEW_RELEASE(1),
    CHILDREN(2);

    private final int code;

    MovieType(int code) {
        this.code = code;
    }

    public static MovieType fromCode(int code) throws InvalidPriceCodeException {
        for (MovieType type : values()) {
            if (type.code == code) {
                return type;
            }
        }

        throw new InvalidPriceCodeException("Invalid Movie Code");
    }
}

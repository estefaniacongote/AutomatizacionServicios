package utils;

public enum Uri {
    LIST_USERS_1("/api/users/2"),
    CREATE_USER("/api/users"),
    UPDATE_USER_1("/api/users/2"),
    DELETE("/api/users/1"),

    LIST_USERS_2("/v2/store/order/6"),
    UPDATE_USER_2("/api/users/2");

    private String uri;

    Uri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}

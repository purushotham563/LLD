public class User {
    private String name;
    private String email;
    private String userId;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return userId;
    }

    public User(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }
}

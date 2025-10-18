package ar.utn.ba.ddsi.grupo24.dto;

public class LoginResponse {
    public boolean error;
    public String message;
    public Data data;

    public static class Data {
        public String access_token;
        public String token_type;
        public User user;
    }

    public static class User {
        public int id;
        public String email;
        public String name;
    }
}


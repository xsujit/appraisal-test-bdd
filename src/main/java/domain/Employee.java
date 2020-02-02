package domain;

import java.util.Map;

public class Employee {

    private String firstName;
    private String lastName;
    private String username;
    private String email;

    public Employee(Map<String, String> userDetails) {
        userDetails.forEach((k, v) -> {
            switch (k) {
                case "firstName":
                    this.firstName = v;
                case "lastName":
                    this.lastName = v;
                case "username":
                    this.username = v;
                case "email":
                    this.email = v;
            }
        });
    }

    public String getEmail() {
        return email;
    }
}

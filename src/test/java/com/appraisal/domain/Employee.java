package com.appraisal.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Employee {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private final Map<String, String> map = new HashMap<>();

    public Employee(Map<String, String> userDetails) {
        map.putAll(userDetails);
        map.put("password", "password");
        map.put("employeeId", String.valueOf(ThreadLocalRandom.current().nextInt(100, 99999999)));
        map.put("location", "Bradford");
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

    public Map<String, String> getMap() {
        return map;
    }
}

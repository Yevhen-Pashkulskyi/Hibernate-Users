package org.example.app.entity;

import java.util.Map;

public class
UserMapper {

    public User mapContactData(Map<String, String> data) {
        User contact = new User();
        if (data.containsKey("id"))
            contact.setId(Long.parseLong(data.get("id")));
        if (data.containsKey("first_name"))
            contact.setFirstName(data.get("first_name"));
        if (data.containsKey("email"))
            contact.setEmail(data.get("email"));
        return contact;
    }
}

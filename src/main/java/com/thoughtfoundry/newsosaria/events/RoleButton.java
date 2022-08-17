package com.thoughtfoundry.newsosaria.events;

import com.thoughtfoundry.newsosaria.data.BotCollections;

public class RoleButton {
    EventType eventType = EventType.RoleButton;
    String id;
    String role;

    public RoleButton(String eventIDString, String label) {
        this.id = eventIDString;
        this.role = label;
        BotCollections.roleButtons.add(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

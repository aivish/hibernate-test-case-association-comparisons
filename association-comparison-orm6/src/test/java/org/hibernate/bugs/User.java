package org.hibernate.bugs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public User(String name) {
        this.name = name;
    }
}

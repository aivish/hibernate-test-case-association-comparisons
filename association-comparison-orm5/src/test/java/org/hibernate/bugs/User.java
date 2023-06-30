package org.hibernate.bugs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

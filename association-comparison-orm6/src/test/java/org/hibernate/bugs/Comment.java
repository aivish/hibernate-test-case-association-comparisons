package org.hibernate.bugs;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    public Long id;

    public String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotFound(action = NotFoundAction.IGNORE)
    public User user;

    public Comment(String text, User user) {
        this.text = text;
        this.user = user;
    }
}

package seanlindev.springframework.domain;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

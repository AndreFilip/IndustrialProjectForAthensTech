package gr.athtech.industrial.codehub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author George Lalas
 */
@Entity
@Table(name = "techstack")
public class Techstack implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "stack")
    private String stack;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "userTechstack")
    private Set<CodeHubUser> users;

    public Techstack() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public Set<CodeHubUser> getUsers() {
        return users;
    }

    public void setUsers(Set<CodeHubUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Techstack{" +
                "id=" + id +
                ", stack='" + stack + '\'' +
                '}';
    }
}

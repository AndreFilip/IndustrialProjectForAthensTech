package gr.athtech.industrial.codehub.model;

import javax.persistence.*;
import java.io.Serializable;

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

    public Techstack() {
    }
}

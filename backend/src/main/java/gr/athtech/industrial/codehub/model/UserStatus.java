package gr.athtech.industrial.codehub.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author George Lalas
 */
@Entity
@Table(name = "user_status")
public class UserStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private CodeHubUser codeHubUser;

    @Column(name = "stage")
    private String stage;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "changedBy")
    private String changedBy;

    public UserStatus() {
    }
}

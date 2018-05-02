package gr.athtech.industrial.codehub.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author George Lalas
 */
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private CodeHubUser codeHubUser;

    @Column(name = "cvPath")
    private String cvPath;

    @Column(name = "avatarPath")
    private String avatarPath;

    @Column(name = "linkedinPath")
    private String linkedInPath;

    @Column(name = "stackoverflowPath")
    private String stackOverflowPath;

    @Column(name = "githubPath")
    private String gitHubPath;

    public UserProfile() {
    }
}

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

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
//    @Column(name = "userId")
    private CodeHubUser codeHubUser;

    @Column(name = "stage")
    private String stage;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "changedBy")
    private String changedBy;

    public UserStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CodeHubUser getCodeHubUser() {
        return codeHubUser;
    }

    public void setCodeHubUser(CodeHubUser codeHubUser) {
        this.codeHubUser = codeHubUser;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "id=" + id +
                ", codeHubUser=" + codeHubUser +
                ", stage='" + stage + '\'' +
                ", timestamp=" + timestamp +
                ", changedBy='" + changedBy + '\'' +
                '}';
    }
}

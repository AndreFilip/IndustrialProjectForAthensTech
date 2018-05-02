package gr.athtech.industrial.codehub.services;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import gr.athtech.industrial.codehub.model.Role;
import gr.athtech.industrial.codehub.model.UserStatus;
import gr.athtech.industrial.codehub.repositories.UserRepository;
import gr.athtech.industrial.codehub.repositories.UserStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * @author George Lalas
 */
@Service("userStatusService")
public class UserStatusService {
    private static final Logger log = LoggerFactory.getLogger(UserStatusService.class);

    @Autowired
    private UserStatusRepository userStatusRepository;
    @Autowired
    private UserRepository userRepository;

    public void changeUserStatus(CodeHubUser user, String stage, String changedBy){
        log.info("Changing status of user : {}", user.getUsername());
        UserStatus userStatus = userStatusRepository.findUserStatusByCodeHubUser(user);
        if(userStatus != null){
            userStatus.setChangedBy(changedBy);
            userStatus.setStage(stage);
            userStatus.setTimestamp(new Date());
            userStatusRepository.save(userStatus);
        }else {
            UserStatus newUserStatus = new UserStatus();
            newUserStatus.setCodeHubUser(user);
            newUserStatus.setStage(stage);
            newUserStatus.setChangedBy(changedBy);
            newUserStatus.setTimestamp(new Date());
            userStatusRepository.save(newUserStatus);
        }
    }
}

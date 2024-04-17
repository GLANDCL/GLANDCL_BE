package GLANDCL.GLANDCL.Config.Oauth;

import GLANDCL.GLANDCL.Entity.User.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }
}

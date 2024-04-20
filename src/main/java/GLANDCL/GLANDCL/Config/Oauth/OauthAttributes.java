package GLANDCL.GLANDCL.Config.Oauth;

import GLANDCL.GLANDCL.Entity.User.MyRole;
import GLANDCL.GLANDCL.Entity.User.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OauthAttributes {

    private Map<String,Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OauthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OauthAttributes of(String registrationId,String userNameAttributeName,Map<String,Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OauthAttributes ofGoogle(String userNameAttributeName,Map<String,Object> attributes) {
        return OauthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(MyRole.USER)
                .build();
    }
}

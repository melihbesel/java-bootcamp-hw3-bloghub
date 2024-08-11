package com.patika.bloghubuserservice.model;


import com.patika.bloghubuserservice.model.enums.StatusType;
import com.patika.bloghubuserservice.model.enums.UserType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Schema(name = "User", description = "User model")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(name = "email", description = "Geçerli bir email olmalıdır", example = "mbesel2005@gmail.com")
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String bio;
    @Enumerated(EnumType.STRING)
    private StatusType statusType;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.userType = UserType.STANDARD;
        this.statusType = StatusType.WAITING_APPROVAL;
    }
    //private Set<SocialMedia> socialMediaList;

    //private List<BlogTag> followedTagList = new ArrayList<>();


}

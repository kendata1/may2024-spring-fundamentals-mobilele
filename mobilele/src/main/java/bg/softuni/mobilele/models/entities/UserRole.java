package bg.softuni.mobilele.models.entities;

import bg.softuni.mobilele.models.enums.Role;
import jakarta.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Role role;
    @OneToOne (mappedBy = "userRole")
    private User user;

    public UserRole () {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

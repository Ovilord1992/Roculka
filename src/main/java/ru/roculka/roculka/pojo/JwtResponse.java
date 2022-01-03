package ru.roculka.roculka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.roculka.roculka.entity.Roles;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";

    private Long id;
    private String username;
    private String email;
    private List<Roles> roles;

    public JwtResponse(String token, Long id, String username, String email, List<Roles> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}

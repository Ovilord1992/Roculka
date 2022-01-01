package ru.roculka.roculka.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;

    private String firstname;
    private String lastname;

    @NonNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime birthDate;

    @Transient
    private Integer age;

    @NonNull
    private String email;
    private String phone;

    private LocalDateTime datecreate;
    private LocalDateTime dateupdate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles;


    //Перед созданием нового пользователя
    @PrePersist
    private void prePersist(){
        datecreate = LocalDateTime.now();
    }

    //Перед обновлением пользователя
    @PreUpdate
    private void preUpdate(){
        dateupdate = LocalDateTime.now();
    }

    //После прогрузки сущности
    @PostLoad
    private void postLoad(){
        //получаем актуальное значение возраста пользователя
        age = LocalDateTime.now().getYear() - birthDate.getYear();
    }

}

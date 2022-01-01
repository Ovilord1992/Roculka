package ru.roculka.roculka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.roculka.roculka.entity.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
}

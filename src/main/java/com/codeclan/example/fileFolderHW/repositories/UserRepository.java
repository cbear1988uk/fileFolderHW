package com.codeclan.example.fileFolderHW.repositories;

import com.codeclan.example.fileFolderHW.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

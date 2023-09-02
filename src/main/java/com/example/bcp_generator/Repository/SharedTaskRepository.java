package com.example.bcp_generator.Repository;

import com.example.bcp_generator.Model.SharedTaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SharedTaskRepository extends JpaRepository<SharedTaskModel,Long> {
}

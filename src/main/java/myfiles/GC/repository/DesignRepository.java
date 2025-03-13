package myfiles.GC.repository;

import myfiles.GC.model.Design;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignRepository extends JpaRepository<Design, Long> {
}
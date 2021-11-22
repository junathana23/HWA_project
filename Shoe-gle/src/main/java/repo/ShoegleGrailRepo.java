package repo;

import org.springframework.data.jpa.repository.JpaRepository;



import domain.ShoegleGrailDomain;

public interface ShoegleGrailRepo extends JpaRepository<ShoegleGrailDomain, Long> {

}

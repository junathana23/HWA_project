package repo;

import org.springframework.data.jpa.repository.JpaRepository;



import domain.ShoeglePortfolioDomain;

public interface ShoeglePortfolioRepo extends JpaRepository<ShoeglePortfolioDomain, Long> {

}

package service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springbootsw.Shoegleportfolio;

import domain.ShoeglePortfolioDomain;
import repo.ShoeglePortfolioRepo;

@Service
public class ShoeglePortfolioService {
public ShoeglePortfolioRepo PortRepo;

public ShoeglePortfolioService(ShoeglePortfolioRepo portRepo) {
	this.PortRepo = portRepo;
}

public ShoeglePortfolioDomain create(ShoeglePortfolioDomain portDomain) {
	return this.PortRepo.save(portDomain);
}

public List<ShoeglePortfolioDomain> getAll(){
	return this.PortRepo.findAll();
}

public ShoeglePortfolioDomain getOne(Long ShoeID) {
	return this.PortRepo.findById(ShoeID).get();
	
}

public ShoeglePortfolioDomain update(Long ShoeID, ShoeglePortfolioDomain queryNew) {
	ShoeglePortfolioDomain updating = this.PortRepo.getById(ShoeID);
	updating.setBrand(queryNew.getBrand());
	updating.setSillouhette(queryNew.getSillouhette());
	updating.setColourway(queryNew.getColourway());
	updating.setSize(queryNew.getSize());
	updating.setCollab(queryNew.isCollab());
	updating.setRetailPrice(queryNew.getRetailPrice());
	updating.setAftermarketPrice(queryNew.getAftermarketPrice());
	
	return this.PortRepo.saveAndFlush(updating);
}
public boolean removeOne(Long ShoeID) {
	this.PortRepo.deleteById(ShoeID);
	return !this.PortRepo.existsById(ShoeID);
}

//public boolean deleteAll() {
//	this.PortRepo.deleteAll();
//	return !this.PortRepo.exists();
//}

}

package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.ShoegleGrailDomain;
import repo.ShoegleGrailRepo;

@Service
public class ShoegleGrailService {
public ShoegleGrailRepo GrailRepo;

public ShoegleGrailService(ShoegleGrailRepo grailRepo) {
	this.GrailRepo = grailRepo;
}

public ShoegleGrailDomain create(ShoegleGrailDomain grailDomain) {
	return this.GrailRepo.save(grailDomain);
}

public List<ShoegleGrailDomain> getAll(){
	return this.GrailRepo.findAll();
}

public ShoegleGrailDomain getOne(Long GrailID) {
	return this.GrailRepo.findById(GrailID).get();
	
}

public ShoegleGrailDomain update(Long GrailID, ShoegleGrailDomain t) {
	ShoegleGrailDomain updating = this.GrailRepo.getById(GrailID);
	updating.setBrand(t.getBrand());
	updating.setSillouhette(t.getSillouhette());
	updating.setColourway(t.getColourway());
	updating.setSize(t.getSize());
	updating.setCollab(t.isCollab());
	updating.setRetailPrice(t.getRetailPrice());
	updating.setAftermarketPrice(t.getAftermarketPrice());
	
	return this.GrailRepo.saveAndFlush(updating);
}
public boolean removeOne(Long ShoeID) {
	this.GrailRepo.deleteById(ShoeID);
	return !this.GrailRepo.existsById(ShoeID);
}

//public boolean deleteAll() {
//	this.PortRepo.deleteAll();
//	return !this.PortRepo.exists();
//}

}

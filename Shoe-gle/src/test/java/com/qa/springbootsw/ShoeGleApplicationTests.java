package com.qa.springbootsw;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import domain.ShoegleGrailDomain;
import domain.ShoeglePortfolioDomain;
import repo.ShoegleGrailRepo;
import repo.ShoeglePortfolioRepo;
import service.ShoegleGrailService;
import service.ShoeglePortfolioService;

@SpringBootTest
class ShoeGleApplicationUnitTests {

    @InjectMocks
    public ShoeglePortfolioService portService;
    public ShoegleGrailService grailService;
    public ShoeglePortfolioRepo portRepo;
    public ShoegleGrailRepo grailRepo;
    
    @Mock
    public Shoegleportfolio port;
    public ShoegleGrail grail;
    
    
	
	@Test
	void contextLoads() {
	}
	//Portfolio Tests
	@Test
	void portfolioCreateTest() throws Exception {
		ShoeglePortfolioDomain queryIn = new ShoeglePortfolioDomain("Niike","VapourMax","Green Volt",8,false,170,210) ;
		ShoeglePortfolioDomain queryOut = new ShoeglePortfolioDomain(1L,"Niike","VapourMax","Green Volt",8,false,170,210) ;
		// Values to be inserted into the table
		Mockito.when(this.portRepo.save(queryIn)).thenReturn(queryOut);
		Assertions.assertEquals(queryOut,this.portService.create(queryIn));
		Mockito.verify(this.portRepo,Mockito.times(1)).saveAndFlush(queryIn);
	}
	
	
	@Test
	public void portGetAllTest() {
		List<ShoeglePortfolioDomain> ShoeOut = new ArrayList<>();
		ShoeOut.add(new ShoeglePortfolioDomain(1L,"Niike","VapourMax","Green Volt",8,false,170,210));
		Mockito.when(this.portRepo.findAll()).thenReturn(ShoeOut);
		
		Assertions.assertEquals(ShoeOut, this.portService.getAll());
		Mockito.verify(this.portRepo,Mockito.times(1)).findAll();
	}
	
	@Test
	public void portGetoneTest() {
		
		Long shoeID = 1L;
    	Shoegleportfolio shoeOut = new Shoegleportfolio(1L,"Niike","VapourMax","Green Volt",8,false,170,210);
    	
    //	Mockito.when(this.portRepo.findById(shoeID)).thenReturn(Optional.of(shoeOut));
        Mockito.doReturn(Optional.of(shoeOut)).when(this.portRepo.findById(shoeID));
    	Assertions.assertEquals(shoeOut, this.portService.getOne(shoeID));
    	Mockito.verify(this.portRepo, Mockito.times(1)).getById(shoeID);
    }
   @Test
   void portUpdateTest()  {
   	Long  shoeId = 1L;
   	ShoeglePortfolioDomain queryOld = new ShoeglePortfolioDomain(1L,"Niike","VapourMax","Green Volt",8,false,170,210) ;
	ShoeglePortfolioDomain queryNew = new ShoeglePortfolioDomain(1L,"Nike","VapourMax","Green Volt",8,false,170,210) ;
		
	 Mockito.doReturn(Optional.of(queryOld)).when(this.portRepo.findById(shoeId));
	 Mockito.doReturn(Optional.of(queryNew)).when(this.portRepo.saveAndFlush(queryOld));

		
	Assertions.assertEquals(queryOld, this.portService.update(shoeId, queryNew));
	Mockito.verify(this.portRepo, Mockito.times(1)).findById(shoeId);
	Mockito.verify(this.portRepo, Mockito.times(1)).saveAndFlush(queryOld);
	
		

}
   
   public void portDeleteOneTest() {
	   long shoeId = 1L;
	   boolean shoeDel = true;
	   Mockito.doReturn(shoeDel).when(this.portService.removeOne(shoeId));
	   Assertions.assertEquals(shoeDel, this.portRepo.existsById(shoeId));
   }
   

   
   
   
   
   
   //Grail Tests
   @Test
	void GrailCreateTest() throws Exception {
		ShoegleGrailDomain queryIn = new ShoegleGrailDomain("Niike","VapourMax","Green Volt",8,false,170,210) ;
		ShoegleGrailDomain queryOut = new ShoegleGrailDomain(1L,"Niike","VapourMax","Green Volt",8,false,170,210) ;
		// Values to be inserted into the table
		Mockito.when(this.grailRepo.save(queryIn)).thenReturn(queryOut);
		Assertions.assertEquals(queryOut,this.grail.create(queryIn));
		Mockito.verify(this.portRepo,Mockito.times(1)).saveAndFlush(queryIn);
	}
   
}


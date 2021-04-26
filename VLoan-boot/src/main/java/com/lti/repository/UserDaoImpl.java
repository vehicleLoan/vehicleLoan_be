package com.lti.repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.dto.ApplicationFormDto;
import com.lti.dto.EmploymentDetailsDto;
import com.lti.dto.PersonalDetailsDto;
import com.lti.entity.BankDetails;
import com.lti.entity.Customer;
import com.lti.entity.Document;
import com.lti.entity.Loan;
import com.lti.entity.VehicleDetails;
import com.lti.service.EmailService;

//@Component
@Repository
public class UserDaoImpl implements UserDao {
	 
	private Document docs=new Document();
	
	@PersistenceContext
	EntityManager em;
	
	

	@Transactional
	public Customer registerACustomer(Customer cust) {
		Customer c=null;
		try {
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.reset();
            
            byte[] b=m.digest(cust.getPassword().getBytes());
            BigInteger bigInt = new BigInteger(1,b);
            
            String hashtext = bigInt.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while(hashtext.length() < 32 ){
              hashtext = "0"+hashtext;
            }
            
            cust.setPassword(hashtext);
            c=em.merge(cust);
            
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return c;
	}


	public boolean Login(int custId, String password) {
		 Customer cust = em.find(Customer.class, custId);
	        if (cust != null) {
	        try {
	            
	            MessageDigest m= MessageDigest.getInstance("MD5");
	            
	            //byte[] b=md.digest(password.getBytes());
	            
	            m.reset();
	            m.update(password.getBytes());
	            byte[] digest = m.digest();
	            BigInteger bigInt = new BigInteger(1,digest);
	            String hashtext = bigInt.toString(16);
	            // Now we need to zero pad it if you actually want the full 32 chars.
	            while(hashtext.length() < 32 ){
	              hashtext = "0"+hashtext;
	            }
	            System.out.println(hashtext+" hash");
	            System.out.println(cust.getPassword()+" password");
	            
	            if (cust != null && cust.getPassword().equals(hashtext))
	                return true;
	            
	        } catch (NoSuchAlgorithmException e) {
	            // TODO Auto-generated catch blo
	            e.printStackTrace();
	        }
	        }
	        return false;
	}

	@Transactional
	public Loan addLoanDetails(ApplicationFormDto appFormDto) {
		// User should be logged in
		//find custbyid
		//set and merge cust details 
		//set and merge vehicle details
		//bank.set bank.setcust merge
		//doc.set and merge
		//Loan.setcust,setvehicle,setdoc and merge
				// personal,emp details added.
		
		BankDetails b = new BankDetails();
		b.setAccountNumber(appFormDto.getAccountNumber());
		b.setBankName(appFormDto.getBankName());
		b.setBranchName(appFormDto.getBranchName());
		b.setIfsc(appFormDto.getIfsc());
		//b.setCustomer(cdetails);
		em.merge(b);
		
		VehicleDetails v= new VehicleDetails();
		v.setVehicleCity(appFormDto.getVehicleCity());
		v.setVehicleMake(appFormDto.getVehicleMake());
		v.setVehicleModel(appFormDto.getVehicleModel());
		v.setVehicleType(appFormDto.getVehicleType());
		v.setVehicleState(appFormDto.getVehicleState());
		VehicleDetails vd = em.merge(v);		//vehicle details added
		
		Loan l = new Loan();
		l.setLoanAmount(appFormDto.getLoanAmount());
		l.setRateOfInterest(7.5);
		l.setTenure(appFormDto.getTenure());
		l.setExistingEmi(appFormDto.getExistingEmi());
		l.setExistingLoanAmount(appFormDto.getExistingLoanAmount());
		l.setExistingLoanBank(appFormDto.getExistingLoanBank());
		
		l.setVehicle(vd);
		//l.setCustomer(cdetails);
		l.setDocument(em.find(Document.class, appFormDto.getDocId()));
		
		Loan loan  = em.merge(l);
		
		System.out.println("Loan applied");
		return loan;

	}
	
	public boolean addEmpDetails(ApplicationFormDto appFormDto) {
		Customer cust=em.find(Customer.class, appFormDto.getCustId());
		
		return false;
	}
	
	public boolean addVehicleDetails(ApplicationFormDto appFormDto) {
		return false;		
	}

	public List<Loan> viewAllLoansByCustId(int id){	
		String jpql = "select l from Loan l where l.customer.custId=:id";
		TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
		query.setParameter("id", id); 
		List<Loan> loans = query.getResultList();
		return loans;
	 }
	
	public List<Loan> viewAllLoans(){
		String jpql = "select l from Loan l where l.customer.custId=:id";
		TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
		return query.getResultList();
	}
	
	
	//not tested
	@Transactional
	public VehicleDetails addvehicle(VehicleDetails vehicle){
        
        VehicleDetails vd= em.merge(vehicle);
       
        return vd;
    }
    public VehicleDetails findveh(int vehicleId){
        return em.find(VehicleDetails.class, vehicleId);
       
    }
    public Document findDocById(int docId){
        return em.find(Document.class, docId);
       
    }
    public Customer findcustomer(int custId){
        Customer c =  em.find(Customer.class, custId);
        return c;
    }
    
    @Transactional
    public void loandetails(Loan l){
        Loan loan=new Loan();
      
        em.merge(l);
        
    }

    @Transactional
	public int  addDocument(Document doc) {
		
		docs = em.merge(doc);
		
		return docs.getDocId();
	}
    @Transactional
	public void addVehicle(VehicleDetails vehicle) {
		
		em.merge(vehicle);
		
	}
    
    @Transactional
	public void addBankAccount(BankDetails bank) {
		
		em.merge(bank);
			
	}
    @Transactional
	public void addLoan(Loan loan){
        
        em.merge(loan);
         
    }
    
    @Transactional
	public boolean isCustomerPresent(String email) {
		return (Long)
				em
				.createQuery("select count(c.custId) from Customer c where c.email = :em")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}
    
    @Transactional
    public Customer resetPassword(String password, int custId) {
        Customer cust = em.find(Customer.class, custId);
        Customer c =new Customer();
        try {
        	
        	MessageDigest m=MessageDigest.getInstance("MD5");
            m.reset();
            
            byte[] b=m.digest(password.getBytes());
            BigInteger bigInt = new BigInteger(1,b);
            
            String hashtext = bigInt.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while(hashtext.length() < 32 ){
              hashtext = "0"+hashtext;
            }
            
            cust.setPassword(hashtext);
            c=em.merge(cust);
            
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
         return c; 

    }

    public boolean forgetPassword(int custId, String email) {
        Customer cust = em.find(Customer.class, custId);
        if(cust.getEmail().equals(email)) {
            return true;
        }else {
            return false;    
        }
        
    }

	@Transactional
	public Customer addPersonalDetals(PersonalDetailsDto appFormDto) {
		int custId = appFormDto.getCustId();
		Customer c = em.find(Customer.class, custId);
		System.out.println(c.getCustFirstName());
		c.setCustFirstName(appFormDto.getCustFirstName());
		c.setCustLastName(appFormDto.getCustLastName());
		c.setGender(appFormDto.getGender());
		c.setDateOfBirth(appFormDto.getDateOfBirth());
		c.setEmail(appFormDto.getEmail());
		c.setPhone(appFormDto.getPhone());
		c.setAddress(appFormDto.getAddress());
		c.setPinCode(appFormDto.getPinCode());
		c.setCity(appFormDto.getCity());
		c.setState(appFormDto.getState());
		Customer cdetails = em.merge(c);
		return cdetails;
	}
	
	@Transactional
	public Customer addEmploymentDetails(EmploymentDetailsDto appFormDto) {
		int custId = appFormDto.getCustId();
		Customer c = em.find(Customer.class, custId);
		c.setEmpType(appFormDto.getEmpType());
		c.setWorkExp(appFormDto.getWorkExp());
		c.setAnnualSal(appFormDto.getAnnualSal());
		c.setCompanyAddress(appFormDto.getCompanyAddress());
		c.setCompanyCity(appFormDto.getCompanyCity());
		c.setCompanyState(appFormDto.getCompanyState());
		c.setCompanyName(appFormDto.getCompanyName());
		c.setProfession(appFormDto.getProfession());
		Customer customer = em.merge(c);
		return customer;
	}
	
	@Override
    @Transactional
    public int vehicledtls(ApplicationFormDto appFormDto) {
        VehicleDetails v= new VehicleDetails();
        v.setVehicleCity(appFormDto.getVehicleCity());
        v.setVehicleMake(appFormDto.getVehicleMake());
        v.setVehicleModel(appFormDto.getVehicleModel());
        v.setVehicleType(appFormDto.getVehicleType());
        v.setVehicleState(appFormDto.getVehicleState());
        VehicleDetails vd = em.merge(v);
        int veh=vd.getVehicleId();
        System.out.println(veh);
        return veh;
    }

	@Transactional
    public BankDetails addBankDetails(ApplicationFormDto appfdto) {
        
        
        Customer cust=em.find(Customer.class,appfdto.getCustId());
        if(cust.getBankAccount()==null) {
        BankDetails b = new BankDetails();
        b.setCustomer(cust);
        b.setAccountNumber(appfdto.getAccountNumber());
        b.setBankName(appfdto.getBankName());
        b.setBranchName(appfdto.getBranchName());
        b.setIfsc(appfdto.getIfsc());
       
        //BankDetails bank = em.find(BankDetails.class, c.getBankAccount().getAccountId());
        BankDetails bank1=em.merge(b);
        return bank1;
        }
        else
        	return cust.getBankAccount();
    }
	
	@Transactional
    public Loan lndtls(ApplicationFormDto appFormDto) {
        int custId = appFormDto.getCustId();
        //System.out.println("before find");
        Customer c = em.find(Customer.class, custId);
        
        if(c.getLoans()==null) {
        //System.out.println("after find");
        List<Loan> lo=new ArrayList<Loan>();
        Loan l = new Loan();
        l.setLoanAmount(appFormDto.getLoanAmount());
        l.setRateOfInterest(7.5);
        l.setTenure(appFormDto.getTenure());
        l.setExistingEmi(appFormDto.getExistingEmi());
        l.setExistingLoanAmount(appFormDto.getExistingLoanAmount());
        l.setExistingLoanBank(appFormDto.getExistingLoanBank());
        l.setStatus("pending");
       
        int vehicleId=appFormDto.getVehicleId();
        VehicleDetails v=em.find(VehicleDetails.class, vehicleId);

        l.setVehicle(v);        
        l.setDocument(em.find(Document.class, appFormDto.getDocId()));
        lo.add(l);
        //c.setLoans(lo);
        //Customer cu  = em.merge(c);
        l.setCustomer(c);
       
        Loan loan  = em.merge(l);
       
        System.out.println("Loan applied");
        return loan;
        }
        else {
        	List<Loan> loans =  c.getLoans();
        	Loan l = new Loan();
            l.setLoanAmount(appFormDto.getLoanAmount());
            l.setRateOfInterest(7.5);
            l.setTenure(appFormDto.getTenure());
            l.setExistingEmi(appFormDto.getExistingEmi());
            l.setExistingLoanAmount(appFormDto.getExistingLoanAmount());
            l.setExistingLoanBank(appFormDto.getExistingLoanBank());
            l.setStatus("pending");
        	loans.add(l);
        	
        	int vehicleId=appFormDto.getVehicleId();
            VehicleDetails v=em.find(VehicleDetails.class, vehicleId);

            l.setVehicle(v);        
            l.setDocument(em.find(Document.class, appFormDto.getDocId()));
            l.setCustomer(c);
            c.setLoans(loans);
            
            em.merge(c);
            
            return l;
        }
    }
	
	 public List<Loan> viewApprove(int id){
	        String jpql = "select l from Loan l where l.status='Approved' and l.customer.custId=:id ";
	        TypedQuery<Loan> query = em.createQuery(jpql, Loan.class);
	        query.setParameter("id", id);
	        List<Loan> loans = query.getResultList();
	        return loans;
	    }
   
}

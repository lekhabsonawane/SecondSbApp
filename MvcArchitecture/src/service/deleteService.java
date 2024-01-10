package service;

import DTO.ResultBean;
import dao.deleteDao;

public class deleteService {
	deleteDao regDao=new deleteDao();
	public ResultBean deleteUser (ResultBean rb) {
		// business logic, check lenghts, empty , 0
		System.out.println("Service");

		if(rb.getPword().length()!=0) {
			System.out.println("Service1");
			ResultBean rb1 =	regDao. deleteUser (rb);
			System.out.println("service-valid password"+rb.isDeleated());
			return rb;
		}else {
			ResultBean rb1  = new ResultBean();
			rb.setDeleated(false);
			System.out.println("valid ");
			return rb;
		
		}
	
}
	
}



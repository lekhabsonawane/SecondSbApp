package service;

import DTO.ResultBean;
import dao.regDao;

public class regService {
	regDao regDao1=new regDao();
	public ResultBean registerUser (ResultBean rb) {
		// business logic, check lenghts, empty , 0
		System.out.println("Service");

		if(rb.getUname().length()>=4 && rb.getPword().length()!=0) {
			ResultBean rb1 =	regDao1.registerUser(rb);
			System.out.println("service-valid password"+rb.isRegistered());
			return rb;
		}else {
			ResultBean rb1  = new ResultBean();
			rb.setRegistered(false);
			System.out.println("valid password");
			return rb;
		
		}
	
}
	
}
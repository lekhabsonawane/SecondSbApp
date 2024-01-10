package service;

import DTO.ResultBean;
import dao.updateDao;

public class updateService {
updateDao regDao=new updateDao();
	public ResultBean updateUser (ResultBean rb) {
		// business logic, check lenghts, empty , 0
		System.out.println("Service");

		if(rb.getPword().length()!=0) {
			System.out.println("Service1");
			ResultBean rb1 =	regDao. updateUser (rb);
			System.out.println("service-valid password"+rb.isUpdated());
			return rb;
		}else {
			ResultBean rb1  = new ResultBean();
			rb.setUpdated(false);
			System.out.println("valid password");
			return rb;
		
		}
	
}
}

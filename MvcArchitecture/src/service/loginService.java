package service;

import DTO.ResultBean;
import dao.loginDao;

public class loginService {
	
	loginDao loginDao1= new loginDao();
	
	public ResultBean checkUser(String uname , String pass) {
		// business logic, check lenghts, empty , 0
		if(pass.length()>=4 && pass.length()!=0) {
			ResultBean rb =	loginDao1.getUser( uname, pass);
			System.out.println("service-valid password"+rb.isLoggedIn());
			return rb;
		}else {
			ResultBean rb  = new ResultBean();
			rb.setLoggedIn(false);
			System.out.println("valid password");
			return rb;
		
		}
	

	
	
		
	}

}

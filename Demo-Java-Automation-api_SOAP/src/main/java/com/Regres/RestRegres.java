package com.Regres;
import com.Regres.postsNew.postsNew;
import com.Regres.user.user;
import com.Regres.update.*;
import com.Regres.Register.Register;
import com.Regres.delete.*;

public class RestRegres {
	
	public final static String baseUrl = "https://reqres.in";
	
	public static postsNew posts(){
		return new postsNew();
	}
	
	public static user user(){
		return new user();
	}
	
	public static update update(){
		return new update();
	}

	public static delete delete(){
		return new delete();
	}
	
	public static Register register(){
		return new Register();
	}
}

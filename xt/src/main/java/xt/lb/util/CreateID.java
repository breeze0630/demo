package xt.lb.util;

import java.util.UUID;

public class CreateID {
	public static String createUserId(){
		UUID uuid = new UUID(12,12);
		
		return uuid.randomUUID().toString();
	}

}

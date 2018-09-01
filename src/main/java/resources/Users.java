package resources;

import java.util.HashMap;
import java.util.Map;

public class Users {

	Map<String, String> user = new HashMap<String, String>();
	Map<String, String> password = new HashMap<String, String>();
	
	public Users() {		
		{
			user.put("com cpf inválido", "12345678901");
			user.put("com cpf não cadastrado", "11798718804");
			user.put("com senha inválida", "43718216779");
			user.put("sem preenchimento", "");
			user.put("sem conexão", "43718216779");
			user.put("com erro no servidor", "74895939480");
		}
		
		{
			password.put("com cpf inválido", "teste");
			password.put("com cpf não cadastrado", "teste");
			password.put("com senha inválida", "111");
			password.put("sem preenchimento", "");
			password.put("sem conexão", "teste");
			password.put("com erro no servidor", "teste");
		}
	}
	
	public String getUser(String statusLogin) {
		return this.user.get(statusLogin);
	}
	
	public String getPassword(String statusLogin) {
		return this.password.get(statusLogin);
	}
	
}

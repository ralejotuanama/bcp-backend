package com.bcp.repo;

import com.bcp.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer>  {

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);	
}

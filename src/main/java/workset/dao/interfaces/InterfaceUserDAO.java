package workset.dao.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import workset.beans.entities.Role;
import workset.beans.entities.User;
import workset.dao.dao.exceptions.DAOException;

public interface InterfaceUserDAO extends Serializable, InterfaceDAO{

	ArrayList<Role> getRoles();
	ArrayList<Role> getRolesForUser(User user);
	
	Role getRole(int id);
	
	ArrayList<User> getUsers();
	User getUser(int id);
	
}

package workset.dao.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import workset.beans.entities.Role;
import workset.beans.entities.User;
import workset.dao.dao.exceptions.DAOException;

public interface InterfaceUserDAO extends Serializable, InterfaceDAO{
	ArrayList<Role> getRoles() throws DAOException;
	ArrayList<Role> getRolesForUser(User user) throws DAOException;
	
	Role getRole(int id) throws DAOException;
	
	ArrayList<User> getUsers() throws DAOException;
	User getUser(int id) throws DAOException;
	
}

package dao;

import metier.Utilisateur;
import java.sql.*;
import java.util.Vector;

public class GestUsersDAO {
	public Utilisateur loadUser(String login, String pass) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from Utilisateurs where login=? and pass=?");
			ps.setString(1, login);
			ps.setString(2, pass);
			ResultSet rsUser = ps.executeQuery();
			if (rsUser.next()) {
				u = new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setName(rsUser.getString("NAME"));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPass(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setVille(rsUser.getString("VILLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	public Utilisateur selectUser(String l) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from Utilisateurs where login=? ");
			ps.setString(1, l);
			ResultSet rsUser = ps.executeQuery();
			if (rsUser.next()) {
				u = new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setName(rsUser.getString("NAME"));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPass(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setVille(rsUser.getString("VILLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public void addUser(String l, String n,String p, String e, String v) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into Utilisateurs (LOGIN,NAME,PASS,EMAIL,VILLE) values(?,?,?,?,?)");
			ps.setString(1, l);
			ps.setString(2, n);
			ps.setString(3, p);
			ps.setString(4, e);
			ps.setString(5, v);
			ps.executeUpdate();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public Vector selectAll() {
		Connection conn = Utilitaire.getConnection();
		Vector users = new Vector();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from Utilisateurs");
			ResultSet rsUser = ps.executeQuery();
			while (rsUser.next()) {
				u = new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setName(rsUser.getString("NAME"));
				u.setPass(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setVille(rsUser.getString("VILLE"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void updateUser(Utilisateur u,String login,String name ,String password,String email,String ville) {
		Connection conn = Utilitaire.getConnection();
		try {
		PreparedStatement ps = conn.prepareStatement("update Utilisateurs set LOGIN=?,NAME=?,PASS=?,EMAIL=?,VILLE=? where LOGIN=?");
		ps.setString(1, login);
		ps.setString(2, name);
		ps.setString(3, password);
		ps.setString(4, email);
		ps.setString(5, ville);
		ps.setString(6, u.getLogin());
		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(Utilisateur u) {
		Connection conn = Utilitaire.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from Utilisateurs where LOGIN=?");
			ps.setString(1, u.getLogin());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
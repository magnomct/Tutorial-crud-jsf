package persistencia;

import java.util.List;
import beans.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UsuarioDAOImp implements UsuarioDAO {

	private Session session = null;
	private Transaction transaction = null;

	public boolean insereUsuario(Usuario usuario) {
		boolean retorno = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			System.out.print("DAO - email: " + usuario.getEmail());
			session.persist(usuario);
			transaction.commit();
			retorno = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return retorno;
	}

	public boolean alteraUsuario(Usuario usuario) {
		boolean retorno = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
			retorno = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return retorno;
	}

	public boolean excluiUsuario(Usuario usuario) {
		boolean retorno = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(session.get(Usuario.class, usuario.getId()));
			transaction.commit();
			retorno = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return retorno;
	}

	public Usuario procurarUsuario(Usuario usuario) {
		Usuario u = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			u = (Usuario) session.get(Usuario.class, usuario.getId());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return u;
	}

	public List<Usuario> procurarTodosUsuario() {
		List<Usuario> list = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			list = session.createQuery("select o from Usuario o").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}

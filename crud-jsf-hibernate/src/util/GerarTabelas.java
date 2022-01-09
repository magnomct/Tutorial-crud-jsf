package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import beans.Usuario;

public class GerarTabelas {

	public static void main(String[] args) {

		AnnotationConfiguration conf = new AnnotationConfiguration()
				.configure("util/hibernate.cfg.xml");
		conf.addAnnotatedClass(Usuario.class);

		SchemaExport sE = new SchemaExport(conf);
		sE.create(true, true);
		
		System.out.println("Tabela " + Usuario.class.getName() + " foi criado.");

	}

}

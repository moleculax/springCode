package org.hibern.config;

import lombok.Getter;
import org.hibern.entity.DepartamentEntity;
import org.hibern.entity.EmployeeEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateConfig {

    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final String CONFIG_PATH = "src/main/resources/hibernate.properties";

    public static SessionFactory buildSessionFactory() {

        var properties = new Properties();

        try {
            properties.load(new FileInputStream(CONFIG_PATH));
            return new Configuration()
                    // .mergeProperties(properties)  // COMENTADO - método no existe en Hibernate 6
                    .addProperties(properties)      // CORRECTO - método equivalente en Hibernate 6
                    .addAnnotatedClass(EmployeeEntity.class)
                    .addAnnotatedClass(DepartamentEntity.class)
                    .buildSessionFactory();

        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración: " + e.getMessage());
            throw new RuntimeException("No se pudo cargar hibernate.properties: " + e.getMessage(), e);
        } catch (Throwable t) {
            System.err.println("Error al construir SessionFactory: " + t.getMessage());
            throw new ExceptionInInitializerError("Error al inicializar Hibernate: " + t.getMessage());
        }
    }

    public static  void shutdown() {
        getSessionFactory().close();
    }


}// END CLASS
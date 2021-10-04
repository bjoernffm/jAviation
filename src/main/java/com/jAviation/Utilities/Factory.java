package com.jAviation.Utilities;

import com.jAviation.Models.Airports.Airport;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Factory {
    public static Airport getAirportByIdentifier(String identifier) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        var sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Airport airport = session.createQuery(
                "select e " +
                        "from Airport e " +
                        "where e.identifier = :id", Airport.class)
                .setParameter( "id", identifier )
                .getSingleResult();
        session.close();

        return airport;
    }
}

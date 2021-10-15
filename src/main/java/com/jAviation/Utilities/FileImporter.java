package com.jAviation.Utilities;

import com.jAviation.Models.Navaids.Navaid;
import com.jAviation.Models.Waypoint;
import com.jAviation.Utilities.Files.AirportsFile;
import com.jAviation.Utilities.Files.NavaidsFile;
import com.jAviation.Utilities.Files.WaypointsFile;
import me.tongfei.progressbar.ProgressBar;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileImporter {
    public static void execute() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            var sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            importNavaids(session);
            importWaypoints(session);
            importAirports(session);
            session.close();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    private static void importFile(List<Waypoint> list, String taskName, Session session) throws IOException {
        session.beginTransaction();

        var i = 0;
        for(Waypoint waypoint: ProgressBar.wrap(list, taskName)) {
            session.save( waypoint );

            i++;
            if(i % 100 == 0) {
                session.getTransaction().commit();
                session.beginTransaction();
            }
        }
        session.getTransaction().commit();
    }

    private static void importNavaids(Session session) throws IOException {
        importFile(new NavaidsFile("src\\main\\resources\\navdata\\Navaids.txt").getNavaids(), "Importing navaids", session);
    }

    private static void importWaypoints(Session session) throws IOException {
        importFile(new WaypointsFile("src\\main\\resources\\navdata\\Waypoints.txt").getWaypoints(), "Importing waypoints", session);
    }

    private static void importAirports(Session session) throws IOException {
        importFile(new ArrayList(new AirportsFile("src\\main\\resources\\navdata\\Airports.txt").getAirports().values()), "Importing airports", session);
    }
}

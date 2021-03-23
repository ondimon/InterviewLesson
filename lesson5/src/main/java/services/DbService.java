package services;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
public class DbService {
    private static DbService dbService;
    public static DbService getInstance() {
        if(dbService == null) {
            dbService = new DbService();
        }
        return dbService;
    }

    private SessionFactory sessionFactory;
    private DbService(){
        sessionFactory = new Configuration()
                .configure("hibernate.h2.cfg.xml")
                .buildSessionFactory();
    }



}

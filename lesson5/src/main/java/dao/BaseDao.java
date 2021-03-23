package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import services.DbService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.ParameterizedType;

public class BaseDao<T> {
    private static final Logger logger = LogManager.getLogger(BaseDao.class);

    private Class<T> tClass;
    private DbService dbService;

    public BaseDao(Class<T> tClass) {
        this.tClass = tClass;
        this.dbService = DbService.getInstance();
    }

    public T get( Long id) {
        Session session = dbService.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        T result = session.get(tClass, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public boolean saveOrUpdate(T o) {
        try {

            Session session = dbService.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (HibernateException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }
}

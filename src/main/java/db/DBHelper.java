package db;

import models.Actor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> T getUnique(Criteria criteria){
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T)criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static <T> T find(Class classType, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria criteria = session.createCriteria(classType);
        criteria.add(Restrictions.idEq(id));
        result = getUnique(criteria);
        return result;
    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getList(Criteria criteria) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> List<T> getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria criteria = session.createCriteria(classType);
        results = getList(criteria);
        return results;
    }

    // loops through a array list actorList then asserts that genre = an actors film genre
    // it then adds this to a new array called actorByGenreList which is then returned
    // so you can use .size on it to find how many are on a certain genre.
    public static List<Actor> numberOfActorsByGenre(String genre) {
        java.util.List<Actor> actorList = DBHelper.getAll(Actor.class);
        java.util.List<Actor> actorByGenreList = new ArrayList<Actor>();
        for (Actor actor : actorList) {
            if (genre.equals (actor.getFilm().getGenre())) {
                actorByGenreList.add(actor);
            }
        }return actorByGenreList;
    }

//    public static List<Actor> findActorsByGenre(String genre){
//        session = HibernateUtil.getSessionFactory().openSession();
//        List<Actor> results = null;
//        try{
//            transaction = session.beginTransaction();
//            Criteria criteria = session.createCriteria(Actor.class);
//            criteria.add(Restrictions.eq("genre", genre));
//            results = criteria.list();
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;
//    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jstore.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.SessionImpl;

/**
 *
 * @author phasnox
 */
public abstract class Generic <T> {

    private EntityManager em;

    public Generic(EntityManager em){
        this.em=em;
    }
    public Generic(){
    }

    public EntityManager getEm(){
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    

    public void persist(Object o){
        
        EntityTransaction transaction = em.getTransaction();

        try {
            //If transaction is active continue with it
            if(!transaction.isActive()) {
                transaction.begin();
            }

            em.persist(o);
            //transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void saveOrUpdate(Object o){

        EntityTransaction transaction = em.getTransaction();

        try {
            //If transaction is active continue with it
            if(!transaction.isActive()) {
                transaction.begin();
            }

            em.merge(o);
            //transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void delete(Object id){
        EntityTransaction transaction = em.getTransaction();

        try {
            //If transaction is active continue with it
            if(!transaction.isActive()) {
                transaction.begin();
            }

            Object o = em.getReference(this.getClass(), id);
            em.remove(o);
            
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<T> findLikeCriteria(Map likes) {
		
                SessionImpl entityManagerImpl = (SessionImpl)  em.getDelegate();
	        Criteria criteria = entityManagerImpl.createCriteria(this.getClass());

                Iterator it = likes.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry pairs = (Map.Entry)it.next();
                    criteria.add(Restrictions.like((String)pairs.getKey(), pairs.getValue()));
                }
                //criteria.list().size();
//                criteria.setFirstResult(0);
//                criteria.setMaxResults(2);
//                criteria.list().size();
                return criteria.list();
	}

    public ScrollableResults findLikeCriteria(Map likes, int fetchSize) {

                SessionImpl entityManagerImpl = (SessionImpl)  em.getDelegate();
	        Criteria criteria = entityManagerImpl.createCriteria(this.getClass());

                Iterator it = likes.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry pairs = (Map.Entry)it.next();
                    criteria.add(Restrictions.like((String)pairs.getKey(), pairs.getValue()));
                }
                criteria.setFetchSize(fetchSize);
                return criteria.scroll();

                //return criteria.list();
	}

    public Object getProperty(String propertyName){
        try {
            return PropertyUtils.getProperty(this, propertyName);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Generic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Generic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Generic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public void setProperty(String propertyName, Object property){
       try {
            PropertyUtils.setProperty(this, propertyName, property);
            return;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Generic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Generic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Generic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

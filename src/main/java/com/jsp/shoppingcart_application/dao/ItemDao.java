package com.jsp.shoppingcart_application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_application.dto.Item;

@Repository
public class ItemDao {
     @Autowired
	private EntityManagerFactory emf;

         public void saveItem(Item item) {
        	 EntityManager em = emf.createEntityManager();
        	 EntityTransaction et = em.getTransaction();
        	 
        	 et.begin();
        	 em.persist(item);
        	 et.commit();
         }
         
         public Item findItemById(int id) {
        	 EntityManager em=emf.createEntityManager();
        	 Item item = em.find(Item.class,id);
        	 return item;
         }
         public void updateItem(Item item) {
        	 EntityManager em = emf.createEntityManager();
        	 EntityTransaction et =em.getTransaction();
        	 et.begin();
        	 em.merge(item);
        	 et.commit();
         }
         
         public void deleteItemById(int id) {
        	 EntityManager em=emf.createEntityManager();
        	 EntityTransaction et = em.getTransaction();
        	 Item i = em.find(Item.class, id);
        	 et.begin();
        	 em.remove(i);
        	 et.commit();
         }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.ejb.bl;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import za.ac.tut.entities.Student;

/**
 *
 * @author Sakhumzi
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "StudentsEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public Student find(String name, String surname) {
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.name = :firstname AND s.surname = :lastname");
        query.setParameter("firstname", name);
        query.setParameter("lastname", surname);
        Student student = (Student)query.getSingleResult();
        return student;
    }

    @Override
    public Integer cntALlPassed() {
        Query query = em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.marks >= 50.0");
        Integer cnt = (Integer)query.getSingleResult();
        return cnt;
    }

    @Override
    public Integer cntAllFailed() {
        Query query = em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.marks < 50.0");
        Integer cnt = (Integer)query.getSingleResult();
        return cnt;
    }

    @Override
    public Integer cntFemalePassed() {
        Query query = em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.marks >= 50.0 AND s.gender = 'Female'");
        Integer cnt = (Integer)query.getSingleResult();
        return cnt;
    }
    @Override
    public Integer cntMalePassed() {
        Query query = em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.marks >= 50.0 AND s.gender = 'Male'");
        Integer cnt = (Integer)query.getSingleResult();
        return cnt;
    }

    @Override
    public Integer cntFemaleFailed() {
        Query query = em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.marks < 50.0 AND s.gender = 'Female'");
        Integer cnt = (Integer)query.getSingleResult();
        return cnt;
    }

    @Override
    public Integer cntMaleFailed() {
        Query query = em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.marks < 50.0 AND s.gender = 'Male'");
        Integer cnt = (Integer)query.getSingleResult();
        return cnt;
    }
    @Override
    public List<Student> sudentAgeRange(Integer ag1, Integer age2) {
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.age >= :sirstAge AND s.age <= :secondAge");
        List<Student> list = (List<Student>)query.getResultList();
        return list;
    }

    @Override
    public Double highest() {
        Query query = em.createQuery("SELECT MAX(s.marks) FROM Student s");
        Double highest = (Double)query.getSingleResult();
        return highest;
    }

    @Override
    public Double lowest() {
         Query query = em.createQuery("SELECT MIN(s.marks) FROM Student s");
        Double highest = (Double)query.getSingleResult();
        return highest;
    }

    @Override
    public Double average() {
         Query query = em.createQuery("SELECT AVG(s.marks) FROM Student s");
        Double highest = (Double)query.getSingleResult();
        return highest;
    }
    
}

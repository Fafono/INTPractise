/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.ejb.bl;

import jakarta.ejb.Local;
import java.util.List;
import za.ac.tut.entities.Student;

/**
 *
 * @author Sakhumzi
 */
@Local
public interface StudentFacadeLocal {

    void create(Student student);

    void edit(Student student);

    void remove(Student student);

    Student find(Object id);

    List<Student> findAll();

    List<Student> findRange(int[] range);

    int count();
    Student find(String name, String surname);
    Integer cntALlPassed();
    Integer cntAllFailed();
    Integer cntFemalePassed();
    Integer cntMalePassed();
    Integer cntFemaleFailed();
    Integer cntMaleFailed();
    List<Student> sudentAgeRange(Integer ag1, Integer age2);
    Double highest();
    Double lowest();
    Double average();
    
}

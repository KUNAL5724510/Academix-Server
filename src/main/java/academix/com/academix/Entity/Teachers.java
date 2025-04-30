package academix.com.academix.Entity;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;

@Entity     
@Table(name = "teachers")
public class Teachers {
    
    @GeneratedValue
    @Id
    private int id;
    
    @Column(name = "salary")
    private int salary;

    @Column(name = "assigned_class_id")
    private int assignedClassId;

    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "last_salary")
    private int lastSalary;

    @Column(name = "increment_date")
    private LocalDate incrementDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAssignedClassId() {
        return assignedClassId;
    }

    public void setAssignedClassId(int assignedClassId) {
        this.assignedClassId = assignedClassId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getLastSalary() {
        return lastSalary;
    }

    public void setLastSalary(int lastSalary) {
        this.lastSalary = lastSalary;
    }

    public LocalDate getIncrementDate() {
        return incrementDate;
    }

    public void setIncrementDate(LocalDate incrementDate) {
        this.incrementDate = incrementDate;
    }
    
}
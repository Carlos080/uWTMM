package mx.edu.uwtmm.VO;
// Generated 1/10/2017 11:19:53 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Calendar generated by hbm2java
 */
@Entity
@Table(name="Calendar"
    ,catalog="bolsa_trabajo"
)
public class Calendar  implements java.io.Serializable {


     private Integer id;
     private Student student;
     private String start;
     private String end;

    public Calendar() {
    }

    public Calendar(Student student, String start, String end) {
       this.student = student;
       this.start = start;
       this.end = end;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCalendar", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idStudent", nullable=false)
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    
    @Column(name="start", nullable=false, length=45)
    public String getStart() {
        return this.start;
    }
    
    public void setStart(String start) {
        this.start = start;
    }

    
    @Column(name="end", nullable=false, length=45)
    public String getEnd() {
        return this.end;
    }
    
    public void setEnd(String end) {
        this.end = end;
    }




}



package mx.edu.uwtmm.VO;
// Generated 14/09/2017 08:24:27 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EnglishLevel generated by hbm2java
 */
@Entity
@Table(name="EnglishLevel"
    ,catalog="bolsa_trabajo"
)
public class EnglishLevel  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<Student> students = new HashSet<Student>(0);

    public EnglishLevel() {
    }

	
    public EnglishLevel(String name) {
        this.name = name;
    }
    public EnglishLevel(String name, Set<Student> students) {
       this.name = name;
       this.students = students;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idEnglishLevel", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="englishLevel")
    public Set<Student> getStudents() {
        return this.students;
    }
    
    public void setStudents(Set<Student> students) {
        this.students = students;
    }




}


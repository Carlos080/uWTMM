package mx.edu.uwtmm.VO;
// Generated 1/10/2017 11:19:53 AM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CareerInstitute generated by hbm2java
 */
@Entity
@Table(name="CareerInstitute"
    ,catalog="bolsa_trabajo"
)
public class CareerInstitute  implements java.io.Serializable {


     private CareerInstituteId id;
     private Career career;
     private Institute institute;

    public CareerInstitute() {
    }

    public CareerInstitute(CareerInstituteId id, Career career, Institute institute) {
       this.id = id;
       this.career = career;
       this.institute = institute;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idCareer", column=@Column(name="idCareer", nullable=false) ), 
        @AttributeOverride(name="idInstitute", column=@Column(name="idInstitute", nullable=false) ) } )
    public CareerInstituteId getId() {
        return this.id;
    }
    
    public void setId(CareerInstituteId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCareer", nullable=false, insertable=false, updatable=false)
    public Career getCareer() {
        return this.career;
    }
    
    public void setCareer(Career career) {
        this.career = career;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idInstitute", nullable=false, insertable=false, updatable=false)
    public Institute getInstitute() {
        return this.institute;
    }
    
    public void setInstitute(Institute institute) {
        this.institute = institute;
    }




}



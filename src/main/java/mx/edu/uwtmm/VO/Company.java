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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name="Company"
    ,catalog="bolsa_trabajo"
    , uniqueConstraints = @UniqueConstraint(columnNames="idAccount") 
)
public class Company  implements java.io.Serializable {


     private Integer id;
     private Account account;
     private BusinessTurn businessTurn;
     private String name;
     private String description;
     private String token;
     private Set<Vacancy> vacancies = new HashSet<Vacancy>(0);

    public Company() {
    }

	
    public Company(Account account, BusinessTurn businessTurn) {
        this.account = account;
        this.businessTurn = businessTurn;
    }
    public Company(Account account, BusinessTurn businessTurn, String name, String description, String token, Set<Vacancy> vacancies) {
       this.account = account;
       this.businessTurn = businessTurn;
       this.name = name;
       this.description = description;
       this.token = token;
       this.vacancies = vacancies;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCompany", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer idCompany) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idAccount", unique=true, nullable=false)
    public Account getAccount() {
        return this.account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idBusinessTurn", nullable=false)
    public BusinessTurn getBusinessTurn() {
        return this.businessTurn;
    }
    
    public void setBusinessTurn(BusinessTurn businessTurn) {
        this.businessTurn = businessTurn;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="description", length=45)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="token", length=45)
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="company")
    public Set<Vacancy> getVacancies() {
        return this.vacancies;
    }
    
    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }




}



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
 * DocumentType generated by hbm2java
 */
@Entity
@Table(name="DocumentType"
    ,catalog="bolsa_trabajo"
)
public class DocumentType  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<DocumentData> documentDatas = new HashSet<DocumentData>(0);

    public DocumentType() {
    }

	
    public DocumentType(String name) {
        this.name = name;
    }
    public DocumentType(String name, Set<DocumentData> documentDatas) {
       this.name = name;
       this.documentDatas = documentDatas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idDocumentType", unique=true, nullable=false)
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="documentType")
    public Set<DocumentData> getDocumentDatas() {
        return this.documentDatas;
    }
    
    public void setDocumentDatas(Set<DocumentData> documentDatas) {
        this.documentDatas = documentDatas;
    }




}



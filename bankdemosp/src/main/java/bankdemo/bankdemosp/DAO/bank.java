package bankdemo.bankdemosp.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class bank {
    @Id
    @GeneratedValue
    private Long id;
    private Long accno;
    private String acname;
    private Long bal;

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccno(Long accno) {
        this.accno = accno;
    }

    public void setAcname(String acname) {
        this.acname = acname;
    }

    public void setBal(Long bal) {
        this.bal = bal;
    }

    public Long getId() {
        return id;
    }

    public Long getAccno() {
        return accno;
    }

    public String getAcname() {
        return acname;
    }

    public Long getBal() {
        return bal;
    }
}

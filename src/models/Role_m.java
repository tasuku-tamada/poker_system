package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import utils.DBUtil;

@Table(name = "m_role")
@NamedQueries({
    @NamedQuery(
        name = "getAllRole",
        query = "SELECT r FROM Role_m AS r"
    )
})
@Entity
public class Role_m {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "magnification", nullable = false)
    private int magnification;

    public static Role_m getRole(int id){
        EntityManager em = DBUtil.createEntityManager();
        Role_m role = em.find(Role_m.class, id);
        em.close();
        return role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagnification() {
        return magnification;
    }

    public void setMagnification(int magnification) {
        this.magnification = magnification;
    }
}

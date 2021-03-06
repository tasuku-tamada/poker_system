package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "m_player")
@NamedQueries({
    @NamedQuery(
            name = "checkLoginNameAndPassword",
            query = "SELECT p FROM Player_m AS p WHERE p.name = :name AND p.password = :pass"
            ),
    @NamedQuery(
            name = "nameDuplicateCheck",
            query = "SELECT COUNT(p) FROM Player_m AS p WHERE p.name = :name"
            )
})
@Entity
public class Player_m {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique=true)
    private String name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "coin", nullable = false)
    private int coin = 100;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}

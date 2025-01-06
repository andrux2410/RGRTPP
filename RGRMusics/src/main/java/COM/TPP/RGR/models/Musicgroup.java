package COM.TPP.RGR.models;

import jakarta.persistence.*;

@Entity
@Table(name = "musicgroups")
public class Musicgroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Column(name = "year_of_established", nullable = false)
    private Integer yearofEstablished;

    // Геттери та сеттери
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public Integer getYearofEstablished() {
        return yearofEstablished;
    }
    public void setYearofEstablished(Integer yearofEstablished) {
        this.yearofEstablished = yearofEstablished;
    }
}
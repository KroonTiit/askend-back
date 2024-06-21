package filter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Filter {

    private @Id
    @GeneratedValue Long id;
    private String name;
    @OneToMany(mappedBy = "filter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Criteria> criterias = new ArrayList<>();

    public Filter(String name, List<Criteria> criterias) {
        this.name = name;
        this.criterias = criterias;
    }
    public Filter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Criteria> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<Criteria> criterias) {
        this.criterias = criterias;
    }
}
package filter;

import jakarta.persistence.*;

@Entity
class Criteria {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String qualifier;
    private String qualifierValue;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_id")
    private Filter filter;

    public Criteria(String name, String qualifier, String value) {
        this.name = name;
        this.qualifier = qualifier;
        this.qualifierValue = value;
    }

    public Criteria() {

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

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getQualifierValue() {
        return qualifierValue;
    }

    public void setQualifierValue(String value) {
        this.qualifierValue = value;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}
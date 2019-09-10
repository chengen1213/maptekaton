package application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "problem")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Solution> solutions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "public_dataset",
            joinColumns = @JoinColumn(
                    name = "problem_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "data_id", referencedColumnName = "id"))
    private Collection<Data> publicDataset;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "private_dataset",
            joinColumns = @JoinColumn(
                    name = "problem_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "data_id", referencedColumnName = "id"))
    private Collection<Data> privateDataset;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(Collection<Solution> solutions) {
        this.solutions = solutions;
    }

    public Collection<Data> getPublicDataset() {
        return publicDataset;
    }

    public void setPublicDataset(Collection<Data> publicDataset) {
        this.publicDataset = publicDataset;
    }

    public Collection<Data> getPrivateDataset() {
        return privateDataset;
    }

    public void setPrivateDataset(Collection<Data> privateDataset) {
        this.privateDataset = privateDataset;
    }
}
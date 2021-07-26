package hiber.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String model;
    @Column
    private int series;

    public void setId(Long id) {
        this.id = id;
    }
    public Car(){}
    public Car(String model,int series){
        this.model=model;
        this.series=series;
    }
    public Long getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "id: "+id+" Машина: "+model+" Серия: "+series;
    }
}

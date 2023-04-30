package hiber.model;


import jakarta.persistence.*;

@Entity
@Table(name = "carTable")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "madel")
    private String model;
    @Column(name = "series")
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + '\'' + ", series=" + series + '}';
    }
}



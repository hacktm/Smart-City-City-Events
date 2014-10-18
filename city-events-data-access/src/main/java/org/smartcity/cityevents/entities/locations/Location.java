package org.smartcity.cityevents.entities.locations;

import org.smartcity.cityevents.entities.BaseEntity;
import org.smartcity.cityevents.entities.events.Event;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Location", schema = BaseEntity.MAIN_SCHEMA_NAME)
public class Location extends BaseEntity {

    private static final String NAME = "location";

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAME + "_sequence")
    @SequenceGenerator(name = NAME + "_sequence", sequenceName = MAIN_SCHEMA_NAME + "." + NAME + "_ID_sequence", allocationSize = 1, initialValue = 1)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> events;

    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

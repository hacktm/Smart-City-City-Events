package org.smartcity.cityevents.entities.statics;

import org.smartcity.cityevents.entities.BaseEntity;
import org.smartcity.cityevents.entities.events.Event;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "EventType", schema = BaseEntity.MAIN_SCHEMA_NAME)
public class EventType extends BaseEntity {

    private static final String NAME = "eventType";

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAME + "_sequence")
    @SequenceGenerator(name = NAME + "_sequence", sequenceName = MAIN_SCHEMA_NAME + "." + NAME + "_ID_sequence", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "type", nullable = false, insertable = true, updatable = true, length = 30, precision = 0)
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}

package org.smartcity.cityevents.entities.events;

import org.smartcity.cityevents.entities.BaseEntity;
import org.smartcity.cityevents.entities.locations.Location;
import org.smartcity.cityevents.entities.statics.EventType;

import javax.persistence.*;

@Entity
@Table(name = "Event", schema = BaseEntity.MAIN_SCHEMA_NAME)
@NamedQueries({
        @NamedQuery(
                name = "Event.getByLocation",
                query = "SELECT event " +
                        "FROM Event event " +
                        "WHERE 1 = 1 " +
                        "AND event.location.name = :location"
        )
})
public class Event extends BaseEntity {

    private static final String NAME = "event";

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAME + "_sequence")
    @SequenceGenerator(name = NAME + "_sequence", sequenceName = MAIN_SCHEMA_NAME + "." + NAME + "_ID_sequence", allocationSize = 1, initialValue = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = EventType.class)
    @JoinColumn(name = "eventTypeId", referencedColumnName = "id", nullable = false)
    private EventType eventType;

    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    private String name;

    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 300, precision = 0)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Location.class)
    @JoinColumn(name = "locationId", referencedColumnName = "id", nullable = false)
    private Location location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

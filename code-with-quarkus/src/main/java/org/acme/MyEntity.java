package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MYENTITY")
public class MyEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID", columnDefinition = "VARCHAR(32)")
    public String id;

    @Column(name = "NMNAME")
    public String name;

    @Column(name = "BNSTARTINGTIME")
    public Long startingTime;

    @Column(name = "BNENDINGTIME")
    public Long endingTime;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

package org.acme;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

@ApplicationScoped
public class MyService {

    private static final Logger LOG = Logger.getLogger(MyService.class);

    @Inject
    private MyEntityRepository repository;

    public MyEntity transactionTest() {

        if(!MyEntity.findAll().list().isEmpty()) {
            throw new RuntimeException("teste");
        }

        MyEntity entity = new MyEntity();
        entity.name = "Name";
        entity.startingTime = new Date().getTime();

        entity = this.persist(entity);
        LOG.warn("After persist: " + MyEntity.findAll().list().get(0));

        entity = this.update(entity);
        LOG.warn("After update method: " + MyEntity.findAll().list().get(0));

        MyEntity entityFromDB = (MyEntity) MyEntity.findAll().list().get(0);
        if(entityFromDB.endingTime == null) {
            throw new RuntimeException("Why is the value of entity.endingTime (from DB) null at this point?");
        }

        return entity;
    }

    @Transactional
    private MyEntity persist(MyEntity obj) {
        return repository.create(obj);
    }

    @Transactional
    private MyEntity update(MyEntity obj) {
        obj.endingTime = new Date().getTime();
        obj = repository.update(obj);

        LOG.warn("Inside update method: " + MyEntity.findAll().list().get(0));

        return obj;
    }





}

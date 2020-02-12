package org.acme;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class MyEntityRepository {

    private static final Logger LOG = Logger.getLogger(MyEntityRepository.class);

    @Transactional
    public MyEntity create(MyEntity obj) {
        obj.persist();
        return obj;
    }

    @Transactional
    public MyEntity update(MyEntity obj) {
        MyEntity objToUpdate = MyEntity.findById(obj.id);
        objToUpdate.name = obj.name;
        objToUpdate.startingTime = obj.startingTime;
        objToUpdate.endingTime = obj.endingTime;

        LOG.info(MyEntity.findAll().list().get(0));

        return objToUpdate;

    }
}

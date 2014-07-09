package hacker.partie.hibtry.dao;

import hacker.partie.model.SvcSentence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jens on 09.07.14.
 */
@Repository
public class SentenceDaoImpl implements SentenceDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveSent(SvcSentence sentence) {
        getCurrentSession().save(sentence);
    }
}

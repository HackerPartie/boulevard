package hacker.partie.services;

import hacker.partie.model.SvcSentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jens on 08.07.14.
 */
@Service
@Transactional
public class SvcSentenceServiceImpl implements SvcSentenceService {

    @Autowired
    private SvcSentenceDao svcSentenceDao;

    @Override
    public void saveSent(SvcSentence sentence) {
        svcSentenceDao.saveSent(sentence);
    }
}

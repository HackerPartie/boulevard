package hacker.partie.hibtry.service;

import hacker.partie.hibtry.dao.SentenceDao;
import hacker.partie.model.SvcSentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jens on 08.07.14.
 */
@Service
@Transactional
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    private SentenceDao sentenceDao;

    @Override
    public void saveSent(SvcSentence sentence) {
        sentenceDao.saveSent(sentence);
    }
}

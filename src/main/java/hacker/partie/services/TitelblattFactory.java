package hacker.partie.services;

import hacker.partie.model.ThreePartSentence;

public class TitelblattFactory {
    
    double nnpCount;
    double svcCount;
    SvcSentenceDao svcSentenceDao;
    NnpSentenceDao nnpSentenceDao;
    
    public TitelblattFactory(SvcSentenceDao svcSentenceDao, NnpSentenceDao nnpSentenceDao, double nnpCount, double svcCount ) {
        this.svcSentenceDao = svcSentenceDao;
        this.nnpSentenceDao = nnpSentenceDao;
        this.nnpCount = nnpCount;
        this.svcCount = svcCount;
    }

    public static TitelblattFactory getInstance() {
        SvcSentenceDao svcSentenceDao = new SvcSentenceDao(); 
        NnpSentenceDao nnpSentenceDao = new NnpSentenceDao();
        double nnpCount = nnpSentenceDao.count();
        double svcCount = svcSentenceDao.count();
        TitelblattFactory instance = new TitelblattFactory(svcSentenceDao, nnpSentenceDao, nnpCount, svcCount);
        return instance;
    }
    
    public ThreePartSentence getSentence() {
        
        double totalSent = nnpCount + svcCount;
        
        double nnpRatio;
        try {
            nnpRatio = (nnpCount / totalSent);
        } catch (ArithmeticException e) {
            return new ThreePartSentence("Wien: Titelball generator", "hat problemen", "mit 0");
        }
        
        double random = Math.random();
        
        if (random < nnpRatio) {
            return nnpSentenceDao.createRandom();
        }
        else 
            return svcSentenceDao.createRandom();
            
    }
}

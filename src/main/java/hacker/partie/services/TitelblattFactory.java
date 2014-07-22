package hacker.partie.services;

import hacker.partie.model.ThreePartSentence;

public class TitelblattFactory {
    
    double nnpCount;
    double svcCount;
    
    public TitelblattFactory(double nnpCount, double svcCount) {
        this.nnpCount = nnpCount;
        this.svcCount = svcCount;
    }
    
    public static TitelblattFactory getInstance() {
        double nnpCount = NnpSentenceDao.count();
        double svcCount = SvcSentenceDao.count();
        TitelblattFactory instance = new TitelblattFactory(nnpCount, svcCount);
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
            return NnpSentenceDao.createRandom();
        }
        else 
            return SvcSentenceDao.createRandom();
            
    }
}

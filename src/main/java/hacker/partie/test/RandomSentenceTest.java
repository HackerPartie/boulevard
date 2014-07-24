package hacker.partie.test;

import hacker.partie.model.ThreePartSentence;
import hacker.partie.services.NnpSentenceDao;

public class RandomSentenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
	    NnpSentenceDao nnpSentenceDao = new NnpSentenceDao();	
	    ThreePartSentence mySentence = nnpSentenceDao.createRandom();
		
		System.out.println("\nZufallssatz:");
		System.out.println(mySentence.getSubject() + " "
				+ mySentence.getVerb() + " "
				+ mySentence.getComplement());

	}

}

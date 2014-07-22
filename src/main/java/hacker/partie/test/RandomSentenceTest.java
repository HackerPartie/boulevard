package hacker.partie.test;

import hacker.partie.model.ThreePartSentence;
import hacker.partie.services.SvcSentenceDao;

public class RandomSentenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		
		ThreePartSentence mySentence = SvcSentenceDao.createRandom();		
		
		System.out.println("\nZufallssatz:");
		System.out.println(mySentence.getSubject() + " "
				+ mySentence.getVerb() + " "
				+ mySentence.getComplement());

	}

}

package hacker.partie.test;

import hacker.partie.model.SvcSentence;
import hacker.partie.services.SvcSentenceDao;

public class RandomSentenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SvcSentence mySentence = SvcSentenceDao.createRandom();
		System.out.println("\nZufallssatz:");
		System.out.println(mySentence.getSubject() + " "
				+ mySentence.getVerb() + " "
				+ mySentence.getComplement());

	}

}

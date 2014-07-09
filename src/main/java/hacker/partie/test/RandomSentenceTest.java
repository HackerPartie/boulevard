package hacker.partie.test;

import hacker.partie.model.SvcSentence;
import hacker.partie.services.SvcSentenceDaoImpl;

public class RandomSentenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		
		SvcSentence mySentence = SvcSentenceDaoImpl.createRandom();
		
		System.out.println("\nZufallssatz:");
		System.out.println(mySentence.getSubject() + " "
				+ mySentence.getVerb() + " "
				+ mySentence.getComplement());

	}

}

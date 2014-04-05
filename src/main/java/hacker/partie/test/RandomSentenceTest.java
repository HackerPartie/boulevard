package hacker.partie.test;

import hacker.partie.model.Sentence;
import hacker.partie.model.SentenceDB;

public class RandomSentenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sentence mySentence = SentenceDB.createRandom();
		System.out.println("\nZufallssatz:");
		System.out.println(mySentence.getSubject() + " "
				+ mySentence.getVerb() + " "
				+ mySentence.getComplement());

	}

}

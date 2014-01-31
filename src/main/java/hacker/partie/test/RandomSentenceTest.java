package hacker.partie.test;

import hacker.partie.database.Sentence;
import hacker.partie.database.SentenceDB;

public class RandomSentenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sentence mySentence = SentenceDB.createRandom();
		System.out.println("\nZufallssatz:");
		System.out.println(mySentence.getObject() + " "
				+ mySentence.getVerb() + " "
				+ mySentence.getComplement());

	}

}

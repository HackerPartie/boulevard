package hacker.partie.testPackage;

import hacker.partie.databasePackage.Sentence;
import hacker.partie.databasePackage.SentenceDB;

public class RandomSentenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sentence mySentence = SentenceDB.createRandomSentence();
		System.out.println("\nZufallssatz:");
		System.out.println(mySentence.getSentenceObject() + " "
				+ mySentence.getSentenceVerb() + " "
				+ mySentence.getSentenceComplement());

	}

}

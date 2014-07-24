package hacker.partie.model;

public class Favourite {
    
    private ThreePartSentence sentence;
    private int score;
    
    public Favourite(ThreePartSentence sentence, int score) {
        this.sentence = sentence;
        this.score = score;
    }
    
    public ThreePartSentence getSentence() {
        return sentence;
    }
    public void setSentence(ThreePartSentence sentence) {
        this.sentence = sentence;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

}

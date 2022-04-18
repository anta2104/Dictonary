public class Word {
    
    private String word;
    private String description;
    private String pronounce;

    public String getDescription() {

        return this.description;
    }

    public  String getWord() {

        return this.word;
    }

    public String getPronounce() {
        return this.pronounce;
    }

    Word (String word, String description, String pronounce) {
        this.word = word;
        this.description = description;
        this.pronounce = pronounce;
    }

}
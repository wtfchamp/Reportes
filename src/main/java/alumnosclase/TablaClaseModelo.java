package alumnosclase;

import java.util.StringJoiner;

public class TablaClaseModelo {
    private String nombre;
    private String thinkDevelopShare;
    private String wordGame;
    private String mixMatch;
    private String whatHappened;
    private String comprehensionMatch;
    private String gapFilling;

    public TablaClaseModelo() {
    }

    public TablaClaseModelo(String nombre, String thinkDevelopShare, String wordGame, String mixMatch, String whatHappened, String comprehensionMatch, String gapFilling) {
        this.nombre = nombre;
        this.thinkDevelopShare = thinkDevelopShare;
        this.wordGame = wordGame;
        this.mixMatch = mixMatch;
        this.whatHappened = whatHappened;
        this.comprehensionMatch = comprehensionMatch;
        this.gapFilling = gapFilling;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getThinkDevelopShare() {
        return thinkDevelopShare;
    }

    public void setThinkDevelopShare(String thinkDevelopShare) {
        this.thinkDevelopShare = thinkDevelopShare;
    }

    public String getWordGame() {
        return wordGame;
    }

    public void setWordGame(String wordGame) {
        this.wordGame = wordGame;
    }

    public String getMixMatch() {
        return mixMatch;
    }

    public void setMixMatch(String mixMatch) {
        this.mixMatch = mixMatch;
    }

    public String getWhatHappened() {
        return whatHappened;
    }

    public void setWhatHappened(String whatHappened) {
        this.whatHappened = whatHappened;
    }

    public String getComprehensionMatch() {
        return comprehensionMatch;
    }

    public void setComprehensionMatch(String comprehensionMatch) {
        this.comprehensionMatch = comprehensionMatch;
    }

    public String getGapFilling() {
        return gapFilling;
    }

    public void setGapFilling(String gapFilling) {
        this.gapFilling = gapFilling;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TablaClaseModelo.class.getSimpleName() + "[", "]")
                .add("nombre='" + nombre + "'")
                .add("thinkDevelopShare='" + thinkDevelopShare + "'")
                .add("wordGame='" + wordGame + "'")
                .add("mixMatch='" + mixMatch + "'")
                .add("whatHappened='" + whatHappened + "'")
                .add("comprehensionMatch='" + comprehensionMatch + "'")
                .add("gapFilling='" + gapFilling + "'")
                .toString();
    }
}

package alumnoindividual;

import java.util.StringJoiner;

public class TablaAlumnoModelo {
    private String idVideo;
    private String asignacion;
    private float trasncript;
    private float wordGame;
    private float ThinkDevelopShare;
    private float mixMatch;
    private float gapFilling;
    private float whatHappened;
    private float comprehensionMatch;

    public TablaAlumnoModelo() {
    }

    public TablaAlumnoModelo(String idVideo, String asignacion, float trasncript, float wordGame, float ThinkDevelopShare, float mixMatch, float gapFilling, float whatHappened, float comprehensionMatch) {
        this.idVideo = idVideo;
        this.asignacion = asignacion;
        this.trasncript = trasncript;
        this.wordGame = wordGame;
        this.ThinkDevelopShare = ThinkDevelopShare;
        this.mixMatch = mixMatch;
        this.gapFilling = gapFilling;
        this.whatHappened = whatHappened;
        this.comprehensionMatch = comprehensionMatch;
    }

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public float getTrasncript() {
        return trasncript;
    }

    public void setTrasncript(float trasncript) {
        this.trasncript = trasncript;
    }

    public float getWordGame() {
        return wordGame;
    }

    public void setWordGame(float wordGame) {
        this.wordGame = wordGame;
    }

    public float getThinkDevelopShare() {
        return ThinkDevelopShare;
    }

    public void setThinkDevelopShare(float thinkDevelopShare) {
        ThinkDevelopShare = thinkDevelopShare;
    }

    public float getMixMatch() {
        return mixMatch;
    }

    public void setMixMatch(float mixMatch) {
        this.mixMatch = mixMatch;
    }

    public float getGapFilling() {
        return gapFilling;
    }

    public void setGapFilling(float gapFilling) {
        this.gapFilling = gapFilling;
    }

    public float getWhatHappened() {
        return whatHappened;
    }

    public void setWhatHappened(float whatHappened) {
        this.whatHappened = whatHappened;
    }

    public float getComprehensionMatch() {
        return comprehensionMatch;
    }

    public void setComprehensionMatch(float comprehensionMatch) {
        this.comprehensionMatch = comprehensionMatch;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TablaAlumnoModelo.class.getSimpleName() + "[", "]")
                .add("idVideo='" + idVideo + "'")
                .add("asignacion='" + asignacion + "'")
                .add("trasncript=" + trasncript)
                .add("wordGame=" + wordGame)
                .add("ThinkDevelopShare=" + ThinkDevelopShare)
                .add("mixMatch=" + mixMatch)
                .add("gapFilling=" + gapFilling)
                .add("whatHappened=" + whatHappened)
                .add("comprehensionMatch=" + comprehensionMatch)
                .toString();
    }
}
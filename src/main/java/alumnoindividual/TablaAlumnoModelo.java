package alumnoindividual;

import java.util.StringJoiner;

public class TablaAlumnoModelo {
    private String preguntaDetonadora;
    private String asignacion;
    private float wordGame;
    private float imagenThinkDevelopShare;
    private float matchImage;
    private float completePrayers;
    private float imagenOrderPrayer;
    private float comprehensionMatch;

    public TablaAlumnoModelo() {
    }

    public TablaAlumnoModelo(String preguntaDetonadora, String asignacion, float wordGame, float imagenThinkDevelopShare, float matchImage, float completePrayers, float imagenOrderPrayer, float comprehensionMatch) {
        this.preguntaDetonadora = preguntaDetonadora;
        this.asignacion = asignacion;
        this.wordGame = wordGame;
        this.imagenThinkDevelopShare = imagenThinkDevelopShare;
        this.matchImage = matchImage;
        this.completePrayers = completePrayers;
        this.imagenOrderPrayer = imagenOrderPrayer;
        this.comprehensionMatch = comprehensionMatch;
    }

    public String getPreguntaDetonadora() {
        return preguntaDetonadora;
    }

    public void setPreguntaDetonadora(String preguntaDetonadora) {
        this.preguntaDetonadora = preguntaDetonadora;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public float getWordGame() {
        return wordGame;
    }

    public void setWordGame(float wordGame) {
        this.wordGame = wordGame;
    }

    public float getImagenThinkDevelopShare() {
        return imagenThinkDevelopShare;
    }

    public void setImagenThinkDevelopShare(float imagenThinkDevelopShare) {
        this.imagenThinkDevelopShare = imagenThinkDevelopShare;
    }

    public float getMatchImage() {
        return matchImage;
    }

    public void setMatchImage(float matchImage) {
        this.matchImage = matchImage;
    }

    public float getCompletePrayers() {
        return completePrayers;
    }

    public void setCompletePrayers(float completePrayers) {
        this.completePrayers = completePrayers;
    }

    public float getImagenOrderPrayer() {
        return imagenOrderPrayer;
    }

    public void setImagenOrderPrayer(float imagenOrderPrayer) {
        this.imagenOrderPrayer = imagenOrderPrayer;
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
                .add("preguntaDetonadora='" + preguntaDetonadora + "'")
                .add("asignacion='" + asignacion + "'")
                .add("wordGame=" + wordGame)
                .add("imagenThinkDevelopShare=" + imagenThinkDevelopShare)
                .add("matchImage=" + matchImage)
                .add("completePrayers=" + completePrayers)
                .add("imagenOrderPrayer=" + imagenOrderPrayer)
                .add("comprehensionMatch=" + comprehensionMatch)
                .toString();
    }
}
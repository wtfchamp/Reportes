package alumnoindividual;

public class TablaAlumnoModelo {
    private String imagenTarea;
    private String asignacion;
    private float wordGame;
    private String imagenThinkDevelopShare;
    private float matchImage;
    private float completePrayers;
    private String imagenOrderPrayer;
    private float comprehensionMatch;

    public TablaAlumnoModelo() {
    }

    public TablaAlumnoModelo(String imagenTarea, String asignacion, float wordGame, String imagenThinkDevelopShare, float matchImage, float completePrayers, String imagenOrderPrayer, float comprehensionMatch) {
        this.imagenTarea = imagenTarea;
        this.asignacion = asignacion;
        this.wordGame = wordGame;
        this.imagenThinkDevelopShare = imagenThinkDevelopShare;
        this.matchImage = matchImage;
        this.completePrayers = completePrayers;
        this.imagenOrderPrayer = imagenOrderPrayer;
        this.comprehensionMatch = comprehensionMatch;
    }

    public String getImagenTarea() {
        return imagenTarea;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public float getWordGame() {
        return wordGame;
    }

    public String getImagenThinkDevelopShare() {
        return imagenThinkDevelopShare;
    }

    public float getMatchImage() {
        return matchImage;
    }

    public float getCompletePrayers() {
        return completePrayers;
    }

    public String getImagenOrderPrayer() {
        return imagenOrderPrayer;
    }

    public float getComprehensionMatch() {
        return comprehensionMatch;
    }

    public void setImagenTarea(String imagenTarea) {
        this.imagenTarea = imagenTarea;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public void setWordGame(float wordGame) {
        this.wordGame = wordGame;
    }

    public void setImagenThinkDevelopShare(String imagenThinkDevelopShare) {
        this.imagenThinkDevelopShare = imagenThinkDevelopShare;
    }

    public void setMatchImage(float matchImage) {
        this.matchImage = matchImage;
    }

    public void setCompletePrayers(float completePrayers) {
        this.completePrayers = completePrayers;
    }

    public void setImagenOrderPrayer(String imagenOrderPrayer) {
        this.imagenOrderPrayer = imagenOrderPrayer;
    }

    public void setComprehensionMatch(float comprehensionMatch) {
        this.comprehensionMatch = comprehensionMatch;
    }
}
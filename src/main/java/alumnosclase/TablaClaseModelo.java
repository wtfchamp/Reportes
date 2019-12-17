package alumnosclase;

import java.util.StringJoiner;

public class TablaClaseModelo {
    private String nombre;
    private String thinkDevelopShare;
    private String wordGame;
    private String matchImage;
    private String orderPrayer;
    private String mixMatch;
    private String completePrayers;

    public TablaClaseModelo() {
    }

    public TablaClaseModelo(String nombre, String thinkDevelopShare, String wordGame, String matchImage, String orderPrayer, String mixMatch, String completePrayers) {
        this.nombre = nombre;
        this.thinkDevelopShare = thinkDevelopShare;
        this.wordGame = wordGame;
        this.matchImage = matchImage;
        this.orderPrayer = orderPrayer;
        this.mixMatch = mixMatch;
        this.completePrayers = completePrayers;
    }

    public String getNombre() {
        return nombre;
    }

    public String getThinkDevelopShare() {
        return thinkDevelopShare;
    }

    public String getWordGame() {
        return wordGame;
    }
    public String getMatchImage() {
        return matchImage;
    }

    public String getOrderPrayer() {
        return orderPrayer;
    }

    public String getMixMatch() {
        return mixMatch;
    }

    public String getCompletePrayers() {
        return completePrayers;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setThinkDevelopShare(String thinkDevelopShare) {
        this.thinkDevelopShare = thinkDevelopShare;
    }

    public void setWordGame(String wordGame) {
        this.wordGame = wordGame;
    }

    public void setMatchImage(String matchImage) {
        this.matchImage = matchImage;
    }

    public void setOrderPrayer(String orderPrayer) {
        this.orderPrayer = orderPrayer;
    }

    public void setMixMatch(String mixMatch) {
        this.mixMatch = mixMatch;
    }

    public void setCompletePrayers(String completePrayers) {
        this.completePrayers = completePrayers;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TablaClaseModelo.class.getSimpleName() + "[", "]")
                .add("nombre='" + nombre + "'")
                .add("thinkDevelopShare='" + thinkDevelopShare + "'")
                .add("wordGame='" + wordGame + "'")
                .add("matchImage='" + matchImage + "'")
                .add("orderPrayer='" + orderPrayer + "'")
                .add("mixMatch='" + mixMatch + "'")
                .add("completePrayers='" + completePrayers + "'")
                .toString();
    }
}

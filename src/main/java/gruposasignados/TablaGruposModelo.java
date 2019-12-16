package gruposasignados;

import java.util.StringJoiner;

public class TablaGruposModelo {
    private Short grado;
    private char grupo;
    private int totalAlumnos;

    public TablaGruposModelo() {
    }

    public TablaGruposModelo(Short grado, char grupo, int totalAlumnos) {
        this.grado = grado;
        this.grupo = grupo;
        this.totalAlumnos = totalAlumnos;
    }

    public Short getGrado() {
        return grado;
    }

    public void setGrado(Short grado) {
        this.grado = grado;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public int getTotalAlumnos() {
        return totalAlumnos;
    }

    public void setTotalAlumnos(int totalAlumnos) {
        this.totalAlumnos = totalAlumnos;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TablaGruposModelo.class.getSimpleName() + "[", "]")
                .add("grado=" + grado)
                .add("grupo=" + grupo)
                .add("totalAlumnos=" + totalAlumnos)
                .toString();
    }
}

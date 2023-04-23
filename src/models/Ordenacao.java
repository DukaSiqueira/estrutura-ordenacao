package models;

public class Ordenacao {

    // Quantidade de números a inserir
    private int totalInsert;
    // Números a inserir
    private int[] dataInsert;

    // Tempo de execução
    private long timeExec;

    public Ordenacao(int totalInsert, int[] dataInsert, long timeExec) {
        this.totalInsert = totalInsert;
        this.dataInsert = dataInsert;
        this.timeExec = timeExec;
    }

    public int getTotalInsert() {
        return totalInsert;
    }

    public void setTotalInsert(int totalInsert) {
        this.totalInsert = totalInsert;
    }

    public int[] getDataInsert() {
        return dataInsert;
    }

    public void setDataInsert(int[] dataInsert) {
        this.dataInsert = dataInsert;
    }

    public long getTimeExec() {
        return timeExec;
    }

    public void setTimeExec(long initialTime) {
        // Forma para que o calculo não retorno negativo
        long elapsedTime = Math.abs(System.nanoTime() - initialTime);
        this.timeExec = (long) Math.ceil(elapsedTime / 1000000000.0);
    }
}

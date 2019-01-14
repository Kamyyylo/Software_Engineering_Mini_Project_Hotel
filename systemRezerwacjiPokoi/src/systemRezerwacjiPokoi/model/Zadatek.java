package systemRezerwacjiPokoi.model;

import java.util.Date;

public class Zadatek {

	private int zadatek;
	private Date dataZwrotuZadatku;

    public Zadatek(int zadatek, Date dataZwrotuZadatku) {
        this.zadatek = zadatek;
        this.dataZwrotuZadatku = dataZwrotuZadatku;
    }
    
        public Zadatek() {
        this.zadatek = -1;
        this.dataZwrotuZadatku = null;
    }

    public int getZadatek() {
        return zadatek;
    }

    public void setZadatek(int zadatek) {
        this.zadatek = zadatek;
    }
    

    public Date getDataZwrotuZadatku() {
        return dataZwrotuZadatku;
    }

    public void setDataZwrotuZadatku(Date dataZwrotuZadatku) {
        this.dataZwrotuZadatku = dataZwrotuZadatku;
    }



}
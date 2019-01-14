package systemRezerwacjiPokoi.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Zadatek {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private int zadatek;
	private Date dataZwrotuZadatku;

    public Zadatek(int zadatek, String dataZwrotuZadatku) throws ParseException {
        this.zadatek = zadatek;
        this.dataZwrotuZadatku = sdf.parse(dataZwrotuZadatku);
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
public class Puu {
    int arvo;
    Puu vasen;
    Puu oikea;

    public Puu(int arvo, Puu vasen, Puu oikea) {
        this.arvo = arvo;
        this.vasen = vasen;
        this.oikea = oikea;
    }    

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Puu comparison = (Puu) o;
		
		boolean vasenSama = false;
		boolean oikeaSama = false;
		if (arvo != comparison.arvo) {
			return false;
		}
		if (vasen == null && comparison.vasen == null) {
			vasenSama = true;
		}
		if (oikea == null && comparison.oikea == null) {
			oikeaSama = true;
		}
		if (vasen != null && comparison.vasen != null) {
			vasenSama = vasen.equals(comparison.vasen);
		}
		if (oikea != null && comparison.oikea != null) {
			oikeaSama = oikea.equals(comparison.oikea);
		}
		return vasenSama && oikeaSama;
	}
    
	@Override
    public String toString() {
        String vasenNimi = "-";
        if (vasen != null) vasenNimi = vasen.toString();
        String oikeaNimi = "-";
        if (oikea != null) oikeaNimi = oikea.toString();
        return "["+arvo+",   \n"+vasenNimi+","+oikeaNimi+"]";
    }
}

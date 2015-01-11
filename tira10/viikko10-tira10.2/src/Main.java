
public class Main {
    
    public static int laskeHuoneet(int[][] kartta) {
		int huoneet = 0;
		boolean[][] kaydyt = new boolean[kartta.length][kartta[0].length];
		for (int i = 0; i < kartta.length; i++) {
			for (int j = 0; j < kartta[i].length; j++) {
				if (kaydyt[i][j] == false) {
					if(kartta[i][j] == 1) kaydyt[i][j] = true;
					else {
						huoneet++;
						kayHuoneLapi(kartta, kaydyt, i, j);
					}
				}
			}
		}
		return huoneet;
    }
	
	private static void kayHuoneLapi(int[][] kartta, boolean[][] kaydyt, int i, int j) {
		if (kaydyt[i][j] == true) return;
		if (kartta[i][j] == 1) {
			kaydyt[i][j] = true;
		} else {
			kaydyt[i][j] = true;
			kayHuoneLapi(kartta, kaydyt, i + 1, j);
			kayHuoneLapi(kartta, kaydyt, i - 1, j);
			kayHuoneLapi(kartta, kaydyt, i, j + 1);
			kayHuoneLapi(kartta, kaydyt, i, j - 1);
		}
	}
    
    public static void main(String[] args) {
        int[][] kartta = {{1,1,1,1,1,1,1,1},
                          {1,0,0,1,0,0,0,1},
                          {1,0,0,1,0,1,1,1},
                          {1,0,0,1,0,1,0,1},
                          {1,1,1,1,1,1,1,1}};
        System.out.println(laskeHuoneet(kartta));
    }        
}
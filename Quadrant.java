 public class Quadrant {

    public int[][] matrix;

    public Quadrant() {

    }

    public void initKvadrat(int m) {
        matrix = new int[m][m];
            for(int i = 0; i < m; i++) {
                for (int j = 0;j < m;j++ ) {
                matrix[i][j] = 0;
            }
        }
    }

    public int dekompKvadrat(int m, int xPos, int yPos, int num, int vinkel) {
        int n = m/2;
        int h = n/2;
        num++;
            //basfall skriv in L med lämplig vinkel
            //fyll in L i mitten med lämplig vinkel
            if(vinkel == 0) {
                //tomt i övre högra kvadranten
                matrix[xPos][yPos] = num;
                matrix[xPos - 1][ yPos] = num;
                matrix[xPos-1][ yPos-1] = num;
            } else if(vinkel == 1) {
                //tomt i undre högra kvadranten
                matrix[xPos][yPos] = num;
                matrix[xPos - 1][yPos] = num;
                matrix[xPos][yPos - 1] = num;
            } else if(vinkel == 2){
                //tomt i undre vänstra kvadranten
                matrix[xPos][yPos] = num;
                matrix[xPos][ yPos - 1] = num;
                matrix[xPos-1][ yPos-1] = num;
            } else {
                //tomt i övre vänstra kvadranten
                matrix[xPos][yPos - 1] = num;
                matrix[xPos - 1][yPos - 1] = num;
                matrix[xPos - 1][yPos] = num;
            }


            if(m >= 4) {
                if(vinkel == 2) {
                    num = dekompKvadrat(n, xPos - n + h, yPos + n - h, num, 2); //upp till höger
                    num = dekompKvadrat(n, xPos + n - h, yPos + n - h, num, 1); //ner till höger
                    num = dekompKvadrat(n, xPos + n - h, yPos - n + h, num, 2); //ner till vänster
                    num = dekompKvadrat(n, xPos - n + h, yPos - n + h, num, 3); //upp till vänster
                } else if(vinkel == 1) {
                    num = dekompKvadrat(n, xPos - n + h, yPos + n - h, num, 0); //upp till höger
                    num = dekompKvadrat(n, xPos + n - h, yPos + n - h, num, 1); //ner till höger
                    num = dekompKvadrat(n, xPos + n - h, yPos - n + h, num, 2); //ner till vänster
                    num = dekompKvadrat(n, xPos - n + h, yPos - n + h, num, 1); //upp till vänster
                }  else if(vinkel == 3) {
                    num = dekompKvadrat(n, xPos - n + h, yPos + n - h, num, 0); //upp till höger
                    num = dekompKvadrat(n, xPos + n - h, yPos + n - h, num, 3); //ner till höger
                    num = dekompKvadrat(n, xPos + n - h, yPos - n + h, num, 2); //ner till vänster
                    num = dekompKvadrat(n, xPos - n + h, yPos - n + h, num, 3); //upp till vänster
                } else{
                    num = dekompKvadrat(n, xPos - n + h, yPos + n - h, num, 0); //upp till höger
                    num = dekompKvadrat(n, xPos + n - h, yPos + n - h, num, 1); //ner till höger
                    num = dekompKvadrat(n, xPos + n - h, yPos - n + h, num, 0); //ner till vänster
                    num = dekompKvadrat(n, xPos - n + h, yPos - n + h, num, 3); //upp till vänster
                }
            }

        return num;
    }
    public void fyllKvadrat(int m) {


        initKvadrat(m);
        dekompKvadrat(m, m/2, m/2, 0, 2);
        for (int i = 0;i < m;i++ ) {
            for (int j = 0;j < m; j++ ) {
                System.out.format("%4d", matrix[i][j]);
            }
        System.out.println();
        }
    }

}

 public class Quadrant {

   public int[][] matrix;

   public Quadrant() {

   }

   public void initKvadrat(int m) {
     matrix = new int[m][m];
     for(int i = 0; i < m; i++) {
       for (int j = 0;j < m;j++ ) {
         matrix[i][j] = -1;
       }
     }
   }

   public int dekompKvadrat(int m, int xPos, int yPos, int num, int vinkel) {

     num++;
     if(m == 2) {
       //basfall skriv in L med lämplig vinkel
       //fyll in L i mitten med lämplig vinkel
       if(vinkel == 0) {
         //tomt i övre högra kvadranten
         matrix[xPos][yPos - 1] = num;
         matrix[xPos + 1][ yPos - 1] = num;
         matrix[xPos + 1][ yPos] = num;
         matrix[xPos][yPos] = 0;
       } else if(vinkel == 1) {
         //tomt i undre högra kvadranten
         matrix[xPos][yPos - 1] = num;
         matrix[xPos - 1][yPos - 1] = num;
         matrix[xPos - 1][yPos] = num;
       } else if(vinkel == 2){
         //tomt i undre vänstra kvadranten
         matrix[xPos - 1][ yPos] = num;
         matrix[xPos - 1][ yPos + 1] = num;
         matrix[xPos][ yPos + 1] = num;
       } else {
         //tomt i övre vänstra kvadranten
         matrix[xPos][yPos + 1] = num;
         matrix[xPos + 1][yPos + 1] = num;
         matrix[xPos + 1][yPos] = num;
       }
       return num;
     }



     if(m >= 4) {
       num = dekompKvadrat(m/2, xPos - m/2 +1, yPos + m/2 - 1, num, 0); //upp till höger
       num = dekompKvadrat(m/2, xPos + m/2, yPos + m/2 - 1, num, 1); //ner till höger
       num = dekompKvadrat(m/2, xPos + m/2, yPos - m/2, num, 2); //ner till vänster
       num = dekompKvadrat(m/2, xPos - m/2 +1, yPos - m/2 , num, 3); //upp till vänster
     }

     return num;
   }
   public void fyllKvadrat(int m) {
     initKvadrat(m);
     dekompKvadrat(m, m/2 - 1, m/2, 0, 0);
     for (int i = 0;i < m;i++ ) {
       for (int j = 0;j < m; j++ ) {
          System.out.print(matrix[i][j] + " ");
       }
       System.out.println();
     }
   }
 }

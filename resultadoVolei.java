
/**
 *
 * @author Cibele Ramos da Silva - 13113050303
 */
import java.io.BufferedReader;
import javax.swing.JFileChooser;
import java.io.File; 
import java.io.FileReader;
import java.util.ArrayList;

public class resultadoVolei {
    

      
    public static void main(String[] args) { 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
           File selectedFile = fileChooser.getSelectedFile();
        //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
         String nomeArquivoSaida = "out-" + selectedFile.getName();

  try{
   //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));   
         // HashMap<String,String[]> example = new HashMap<String,String[]>();
          FileReader inputFile = new FileReader(selectedFile);
          BufferedReader bufferReader = new BufferedReader(inputFile);
        
          ArrayList<String> arraylist = new ArrayList<String>();
         
          String line;
          
          while ((line = bufferReader.readLine()) != null)   {       
        
              
             String[] times = line.split("vs|\\/|\\-");
             String timeVencedor;
             String pontoVencedor;
             String pontosVencedor = "";
             String pontosPerdedor = "";
                     
             timeVencedor = times[0];
             String timePerdedor = times[1];
              /*
             
 VITÓRIA ou por 3x0, ou por 3x1 – o vencedor ganha três pontos;
 DERROTA ou por 0x3, ou por 1x3 – o perdedor não ganha nenhum ponto;
 VITÓRIA por 3x2 – o vencedor ganha dois pontos; e
 DERROTA por 2x3 – o perdedor ganha um ponto
                      */
            pontoVencedor = times[2];
            
            if (pontoVencedor == "3-2") {
                pontosVencedor = "2";
                pontosPerdedor = "1";
                        
            } else if ((pontoVencedor == "3-0") || (pontoVencedor == "3-1")) {
                pontosVencedor = "3";
                pontosPerdedor = "0";
            }
            
        arraylist.add(timeVencedor);
        arraylist.add(pontosVencedor);
        arraylist.add(timePerdedor);
        arraylist.add(pontosPerdedor);

        System.out.println(arraylist);
        arraylist.removeAll(arraylist);
          }
      
          bufferReader.close();
          



  }catch (Exception f) {
      
  }
}
    }
    
}
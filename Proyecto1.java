import java.util.List;
import java.util.ArrayList;

class Proyecto1 {

  record Pais(String pais,int poblacion,double porcentajeAccesoAguaPotable,int poblacionAfectadaSequias, int numeroHospitales,int hospitalesProblemasDeSaneamiento, double numeroPlantasPotabilizadorasPor100mh){};

  public static void main(String[] args){
    List<Pais> listaPaises = new ArrayList<Pais>();
    listaPaises.add( new Pais("Colombia", 50340000, 72.3, 4500000, 3500,900, 15.7) );
    listaPaises.add( new Pais("Argentina", 46044703, 88.6, 1400000, 4200, 150, 32.1) );
    listaPaises.add( new Pais("Bolivia", 11216000, 61.9, 1600000, 1021,400, 9.7) );
    listaPaises.add( new Pais("Chile", 17574003, 92.6, 958100, 3200, 98, 48.9) );
    listaPaises.add( new Pais("Venezuela", 32605423, 24.5, 10800000, 1207, 2100, 14.8) );
    listaPaises.add( new Pais("Haití", 11488792, 16.3, 950000, 420, 950, 5.2) );
    listaPaises.add( new Pais("Uruguay", 3286314, 97.9, 410, 3130, 45, 21.4) );


    System.out.println(promedioAccesoAgua(listaPaises));

  }

  
  //Metodos
  public static double promedioAccesoAgua(List<Pais> listaPaises){
        int totalPaises = listaPaises.size();
        double suma = 0;
        for (int i = 1; i < totalPaises; i++) {
            suma += listaPaises.get(i).porcentajeAccesoAguaPotable;
        }
        return suma / totalPaises;
        }

}


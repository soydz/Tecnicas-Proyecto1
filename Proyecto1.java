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
    listaPaises.add(new Pais("Costa Rica", 94.7, 45000, 120, 85, 240));
    listaPaises.add(new Pais("Cuba", 120000, 89.1, 320, 280, 870));
    listaPaises.add(new Pais("Ecuador", 750000, 79.6,  1800, 1300, 5600));
    listaPaises.add(new Pais("El Salvador", 95000,86.8, 250, 180, 1200));
    listaPaises.add(new Pais("Guatemala", 1100000, 72.9, 670, 550, 4200));
    listaPaises.add(new Pais("Honduras", 680000,76.2,  520, 430, 3200));
    listaPaises.add(new Pais("México", 3200000, 89.9, 3500, 2600, 9800));
    listaPaises.add(new Pais("Nicaragua", 540000, 66.5, 780, 650, 4800));
    listaPaises.add(new Pais("Panamá", 78000, 92.3, 190, 120, 360));
    listaPaises.add(new Pais("Paraguay", 610000, 68.4, 890, 750, 5800));
    listaPaises.add(new Pais("Perú", 1800000, 84.7,  2400, 1900, 7500));
    listaPaises.add(new Pais("República Dominicana", 350000, 81.5, 620, 550, 1800));
    listaPaises.add(new Pais("Guayana Francesa", 50000,88.7, 50, 40, 120));
        


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


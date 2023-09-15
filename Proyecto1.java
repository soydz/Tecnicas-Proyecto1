import java.util.List;
import java.util.ArrayList;

class Proyecto1 {

record Pais(String pais,Integer poblacion,Double porcentajeAccesoAguaPotable,Integer poblacionAfectadaSequias,Integer numeroHospitales,Integer hospitalesProblemasDeSaneamiento, Double numeroPlantasPotabilizadorasPor100mh){};

  public static void main(String[] args){
    List<Pais> listaPaises = new ArrayList<Pais>();
    listaPaises.add( new Pais("Colombia", 50340000, 72.3, 4500000, 3500,900, 15.7) );
    listaPaises.add( new Pais("Argentina", 46044703, 88.6, 1400000, 4200, 150, 32.1) );
    listaPaises.add( new Pais("Bolivia", 11216000, 61.9, 1600000, 1021,400, 9.7) );
    listaPaises.add( new Pais("Chile", 17574003, 92.6, 958100, 3200, 98, 48.9) );
    listaPaises.add( new Pais("Venezuela", 32605423, 24.5, 10800000, 1207, 2100, 14.8) );
    listaPaises.add( new Pais("Haití", 11488792, 16.3, 950000, 420, 950, 5.2) );
    listaPaises.add( new Pais("Uruguay", 3286314, 97.9, 410, 3130, 45, 21.4) );
    listaPaises.add( new Pais("Costa Rica", 5100000, 94.7, 280000, 900, 240, 11.3));
    listaPaises.add( new Pais("Cuba", 11200000, 89.1, 400000, 700, 250, 13.3));
    listaPaises.add( new Pais("Ecuador", 17800000, 79.6,  1100000, 1650, 380, 14.2));
    listaPaises.add( new Pais("El Salvador", 6300000, 86.8, 600000, 619, 320, 9.2));
    listaPaises.add( new Pais("Guatemala", 17100000, 72.9, 7200000, 1300, 430, 12.3));
    listaPaises.add( new Pais("Honduras", 10200000, 76.2,  900000, 1716, 320, 11.3));
    listaPaises.add( new Pais("México", 126200000, 89.9, 9300000, 4900, 1230, 16.2));
    listaPaises.add( new Pais("Nicaragua", 6850000, 66.5, 740000, 1343, 410, 10.6));
    listaPaises.add( new Pais("Panamá", 4350000, 92.3, 380000, 209, 89, 17.1));
    listaPaises.add( new Pais("Paraguay", 6700000, 68.4, 1200000, 217, 98, 11.2));
    listaPaises.add( new Pais("Perú", 33700000, 84.7,  1700000, 3807, 1230, 16.));
    listaPaises.add( new Pais("República Dominicana", 11100000, 81.5, 960000, 960, 287, 13.9));
    listaPaises.add( new Pais("Guayana Francesa", 300000, 88.7, 30000, 40, 23, 7.3));
    
    //Promedio de de acceso al agua por país
    promedioAccesoAgua(listaPaises);
    
    //País con más hospitales por cada 100.000 mil habitantes
    paisMasHospitalesPorCienMilPersonas(listaPaises);
    
    //País con más acceso al agua 
    paisMayorAccesoAgua(listaPaises);
   
    //País con menos acceso al agua 
   paisMenosAccesoAgua(listaPaises);
    
    // Porcentaje de Hospitales e nProblemas
    porcentajeHospitalesProblemas(listaPaises);
    
    // Mediana de la poblacion de los paises latinoamericanos
    medianaPoblacion(listaPaises);
    
    //porcentage de personas sin acceso al agua por país
    porcentajePaisPersonasinAccesoAguaP(listaPaises);
    
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
  
  public static String paisMayorAccesoAgua(List<Pais> listaPaises){
      String pais = "";
      double porcentajeAccesoAguaPotable = 0;
      
        for(Pais i: listaPaises){
            double a = i.porcentajeAccesoAguaPotable;
        
            if(a>porcentajeAccesoAguaPotable){
                pais = i.pais;
                porcentajeAccesoAguaPotable = a;
            }
        }
       
        return" El con país mayor acceso al agua potable es: " + pais + " con el: " + porcentajeAccesoAguaPotable + "  % ";
        }
  
  public static String paisMenosAccesoAgua(List<Pais> listaPaises){
      String pais = "";
      Pais accesoAguaPotables= listaPaises.get(0);
      double porcentajeAccesoAguaPotable = accesoAguaPotables.porcentajeAccesoAguaPotable;
      
        for(Pais i: listaPaises){
            double a = i.porcentajeAccesoAguaPotable;
            
            if(a < porcentajeAccesoAguaPotable){
                pais = i.pais;
                porcentajeAccesoAguaPotable = a;
            }
            
          
        }
       
        return" El con país menor acceso al agua potable es: " + pais + " con el: " + porcentajeAccesoAguaPotable + "  % ";
        }
  
  


  public static String paisMasHospitalesPorCienMilPersonas(List<Pais> listaPaises){
    String pais = "";
    double numeroHospitales = 0;

    for(Pais i: listaPaises){
      double a = i.poblacion / 100000;
      double b = i.numeroHospitales / a;
      
      pais = i.pais;
      numeroHospitales = b;

      if( b > numeroHospitales ){
        pais = i.pais;
        numeroHospitales = b;
      }

    }
    return pais + " tiene " + numeroHospitales + " hospitales por cada 100 000 habitantes, siendo el que mas tiene en latinoamerica";
  }


  public static ArrayList porcentajeHospitalesProblemas(List<Pais> listaPaises){
    record dato(String pais, Double porcentajeHospitales){};
    ArrayList<dato> lista = new ArrayList<dato>();

    for(Pais i: listaPaises){
      Double porcentaje = (Double.valueOf(i.hospitalesProblemasDeSaneamiento) * 100) / i.numeroHospitales;

      lista.add( new dato(i.pais, porcentaje) );
    }
    return lista;
  }

  public static ArrayList porcentajePaisPersonasinAccesoAguaP(List<Pais> listaPaises){
    record dato(String pais, Double personasSinAguaPotablePorcentaje){};
    ArrayList<dato> lista = new ArrayList<dato>();
    double porcentajeGlobal = 100;

    for(Pais i: listaPaises){
      Double porcentaje = (Double.valueOf(porcentajeGlobal - i.porcentajeAccesoAguaPotable));

      lista.add( new dato(i.pais, porcentaje) );
    }
    return lista;
  }


  public static Double medianaPoblacion(List<Pais> listaPaises){
    ArrayList<Integer> poblacion = new ArrayList<Integer>();
    
    for(Pais i:listaPaises){
      poblacion.add(i.poblacion);
    }

    ArrayList<Integer> poblacionOrdenada = (ArrayList<Integer>) ordenarDatos(poblacion).clone();

    if((poblacionOrdenada.size() % 2) == 0){
      int dato = poblacionOrdenada.size() / 2; 
      Integer mediana = (poblacionOrdenada.get(dato - 1) + poblacionOrdenada.get(dato)) / 2;

      return Double.valueOf(mediana);

    }else {
      int dato = (int)Math.floor(poblacionOrdenada.size() / 2);
      Integer mediana = poblacionOrdenada.get(dato);

      return Double.valueOf(mediana);
    }
  }


  public static ArrayList ordenarDatos(ArrayList<Integer> lista){
    ArrayList<Integer> listaOrdenada = lista;

    for(int i = 1; i < lista.size(); i++){

      for(int j = 0; j < (lista.size()) - i; j++){
        
        if(listaOrdenada.get(j) > listaOrdenada.get((j+1))){
          Integer num = listaOrdenada.get((j+1));
          listaOrdenada.set((j+1), listaOrdenada.get(j));
          listaOrdenada.set(j, num);
        }
      }    
    }

      return listaOrdenada;

  }


}


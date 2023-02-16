package utilerias.comunes;

import entradasalida.SalidaPorDefecto;

public class Comparador {
    /**
     * Compara dos objetos para ver como son entre ellos.
     * @param objetoPrincipal Es el objeto que se va a comparar.
     * @param objetoSecundario Es el objeto con el que se comparara el objetoPrincipal
     * @return Regresa -1 si es menor 0 si es igual o 1 si es mayor
     */
    public static Integer comparador(Object objetoPrincipal, Object objetoSecundario){
        if(objetoPrincipal instanceof Number && objetoSecundario instanceof Number){
            if (((Number) objetoPrincipal).doubleValue() > ((Number) objetoSecundario).doubleValue()){
                return 1;
            }else if(((Number) objetoPrincipal).doubleValue() < ((Number) objetoSecundario).doubleValue()){
                return -1;
            }else{
                return 0;
            }
        }else if(objetoPrincipal.getClass().toString().equals(objetoSecundario.getClass().toString())){
            int resultado = (objetoPrincipal.toString().compareTo(objetoSecundario.toString()));
            if(resultado<0){
                return -1;
            } else if (resultado>0) {
                return 1;
            }else{
                return 0;
            }
        }else if (((objetoPrincipal instanceof Character) && (objetoSecundario instanceof String)) ||
                ((objetoSecundario instanceof Character) && (objetoPrincipal instanceof String))){
            int resultado = (objetoPrincipal.toString().compareTo(objetoSecundario.toString()));
            if(resultado<0){
                return -1;
            } else if (resultado>0) {
                return 1;
            }else{
                return 0;
            }
        }
        else{
            return null;
        }
    }
}

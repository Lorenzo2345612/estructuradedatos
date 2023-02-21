package utilerias.comunes;

public class ConversorDeDatos {
    /**
    * Metodo auxiliar que convierte un object a double.
    * @param o Objeto a convertir.
    * @return Regresa el valor Double del objeto.
    */
    public static Double objectToDouble(Object o) {
        if(!(o instanceof Number))return null;
        return ((Number) o).doubleValue();
    }

    /**
     * Metodo auxiliar que convierte un object a double.
     * @param o Objeto a convertir.
     * @return Regresa el valor entero del objeto.
     */
    public static Integer objectToInteger(Object o){
        if(!(o instanceof Integer numero))return null;
        return numero;
    }
}

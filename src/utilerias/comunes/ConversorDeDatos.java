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


    public static Object[] doubleArrayToObjectArray(double[] info){
        Object[] temporal = new Object[info.length];
        for (int iterador = 0; iterador < info.length; iterador++) {
            temporal[iterador]=info[iterador];
        }
        return temporal;
    }

    public static double[] objectArrayToDoubleArray(Object[] info){
        double[] temporal = new double[info.length];
        for (int iterador = 0; iterador < info.length; iterador++) {
            temporal[iterador]=(double)info[iterador];
        }
        return temporal;
    }
}

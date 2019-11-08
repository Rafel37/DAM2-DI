public class Menu {

    protected String menuGenerico() {
        String menu = "### CENTRALITA DE LLAMADAS ###\n" +
                "1. Registrar llamadas\n" +
                "2. Ver informacion de llamadas\n" +
                "3. Ver coste total facturado\n" +
                "4. Exportar datos a fichero\n" +
                "5. Importar datos de un fichero" +
                "0. Salir del menu";
        return menu;
    }

    protected String menuRegistrarLlamada() {

        String menu = "### REGISTRAR LLAMADAS ###\n" +
                "1. Local\n" +
                "2. Nacional\n" +
                "3. Interbnacional" +
                "0. Salir del menu";
        return menu;
    }
    protected String menuInformacioLlamada() {

        String menu = "### INFORMACION LLAMADAS ###\n" +
                "1. Local\n" +
                "2. Nacional\n" +
                "3. Interbnacional\n" +
                "4. Todas" +
                "0. Salir del menu";
        return menu;
    }
}

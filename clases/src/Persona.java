public class Persona {

    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
//        if(nombre.length()==0)
//            System.out.println("Es una cadena vacia ");
//        else
            this.nombre = nombre;

    }
//JavaDocs
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void caminar(){
       // System.out.println("La persona "+nombre+ " puede caminar");
    }

    public void ensenar(){

        //System.out.println("La persona "+nombre+ " puede ensena");
    }

}

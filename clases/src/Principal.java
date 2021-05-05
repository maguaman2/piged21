public class Principal {

    public static void main(String[] args) {

//        Persona personaUno;
//        personaUno = new Persona();
//        personaUno.setNombre("Marco");
//        personaUno.setApellido("Guaman");
//        personaUno.setEdad(38);
//        String nombreUno = personaUno.getNombre();
//        System.out.println("El nombre de esta instancia es "+personaUno.getNombre());
//        System.out.println(personaUno.getApellido()+" "+personaUno.getEdad());
//        System.out.println(personaUno.getApellido());
//        System.out.println(personaUno.getEdad());

          Persona personaNueva = new Persona("Marco","Guaman",25);
        System.out.println("El nombre de esta instancia es "+personaNueva.getNombre());
        System.out.println(personaNueva.getApellido()+" "+personaNueva.getEdad());
        System.out.println(personaNueva.getApellido());
        System.out.println(personaNueva.getEdad());

    }

}

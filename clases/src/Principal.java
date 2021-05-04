public class Principal {

    public static void main(String[] args) {

        Persona personaUno;
        personaUno = new Persona();
        personaUno.nombre="Marco";
        personaUno.apellido="Guaman";
        personaUno.edad = 18;
        personaUno.caminar();
        personaUno.ensenar();

        Credito credito = new Credito();
        credito.fecha= "03/05/2021";
        credito.persona=personaUno;

        Persona personaDos =new Persona();
        personaDos.nombre="Alejandro";
        personaDos.apellido="Roldan";
        personaDos.edad=18;
        personaDos.caminar();

        Persona personaTres = new Persona();
        personaTres.nombre="Andrea";
        personaTres.apellido="Loja";
        personaTres.edad=18;
        personaTres.caminar();

        Persona personaCuatro = new Persona();
        personaCuatro.nombre="Nocolas";

    }

}

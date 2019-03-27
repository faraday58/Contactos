package com.temas.selectos.contactos;

public class Contacto {
    private String nmbreContact;
    private String telefono;
    private String Correo;

    public String getNmbreContact() {
        return nmbreContact;
    }

    public void setNmbreContact(String nmbreContact) {
        this.nmbreContact = nmbreContact;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Contacto(String nmbreContact, String telefono, String correo) {
        this.setNmbreContact(nmbreContact);
        this.setTelefono(telefono);
        setCorreo(correo);
    }


}

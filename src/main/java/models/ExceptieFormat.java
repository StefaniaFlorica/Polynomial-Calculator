package models;

public class ExceptieFormat extends Exception{
    public ExceptieFormat () {}//neaparat trebuie sa avem doi construtori(cu param si fara)
    public ExceptieFormat(String msg)
    {
        super(msg);
    }

}

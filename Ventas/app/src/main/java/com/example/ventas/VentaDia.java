package com.example.ventas;

import java.util.List;

public class VentaDia
{
    private String idzona;

    private String idvend;

    private List<Pedidos> pedidos;

    private List<Clientes> clientes;

    public String getIdzona ()
    {
        return idzona;
    }

    public void setIdzona (String idzona)
    {
        this.idzona = idzona;
    }

    public String getIdvend ()
    {
        return idvend;
    }

    public void setIdvend (String idvend)
    {
        this.idvend = idvend;
    }

    public List<Pedidos> getPedidos ()
    {
        return pedidos;
    }

    public void setPedidos (List<Pedidos> pedidos)
    {
        this.pedidos = pedidos;
    }

    public List<Clientes> getClientes ()
    {
        return clientes;
    }

    public void setClientes (List<Clientes> clientes)
    {
        this.clientes = clientes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [idzona = "+idzona+", idvend = "+idvend+", pedidos = "+pedidos+", clientes = "+clientes+"]";
    }
}

